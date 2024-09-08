package com.asss.pj.TuristickaAgencija.aspect;

import com.asss.pj.TuristickaAgencija.entity.TuristickiPaket;
import com.asss.pj.TuristickaAgencija.service.TuristickiPaketService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.logging.Logger;

@Aspect// proxy design patter
@Component//
@Order(2)
public class TuristickiPaketObavestenje {

    private final Logger myLogger = Logger.getLogger(getClass().getName());

    private final TuristickiPaketService turistickiPaketService;

    @Autowired
    public TuristickiPaketObavestenje(TuristickiPaketService turistickiPaketService) {
        this.turistickiPaketService = turistickiPaketService;
    }

    @Pointcut("execution(* com.asss.pj.TuristickaAgencija.contoller.TuristickiPaketController.updateTuristickiPaket(..))")
    private void forUpdate() {

    }

    @Pointcut("execution(* com.asss.pj.TuristickaAgencija.service.TuristickiPaketServiceImpl.deleteById(..))")
    private void forDeleteById() {

    }


    @Before("forUpdate() && args(turistickiPaket)")
    public void obavestenjeForUpdate(JoinPoint theJoinPoint, TuristickiPaket turistickiPaket) {

        myLogger.info("Turisticki paket sa destinacijom " + turistickiPaket.getDestinacija() + " je promenjen!");
        myLogger.info("\n" + "Posle azuriranja: ");

        myLogger.info("\n" + turistickiPaket.toString() + "");

    }

    @Before("forDeleteById() && args(turistickiPaketId)")
    public void obavestenjeForDeleting(JoinPoint theJoinPoint, int turistickiPaketId) {
        System.out.println("logg");

        Optional<TuristickiPaket> turistickiPaketOptional = turistickiPaketService.findById(turistickiPaketId);

        if (turistickiPaketOptional.isPresent()) {
            TuristickiPaket turistickiPaket = turistickiPaketOptional.get();

            myLogger.info("Turisticki paket sa destinacijom " + turistickiPaket.getDestinacija() + " je obrisan!");
        }
    }

}
