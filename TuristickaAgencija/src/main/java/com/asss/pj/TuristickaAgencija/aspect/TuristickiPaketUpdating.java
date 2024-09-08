package com.asss.pj.TuristickaAgencija.aspect;

import com.asss.pj.TuristickaAgencija.entity.SpecijalnaPonuda;
import com.asss.pj.TuristickaAgencija.entity.TuristickiPaket;
import com.asss.pj.TuristickaAgencija.repo.TuristickiPaketRepo;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect// proxy design patter
@Component//
@Order(1)
public class TuristickiPaketUpdating {

    private final Logger myLogger = Logger.getLogger(getClass().getName());

    private final TuristickiPaketRepo turistickiPaketRepo;

    @Autowired
    public TuristickiPaketUpdating(TuristickiPaketRepo turistickiPaketRepo) {
        this.turistickiPaketRepo = turistickiPaketRepo;
        System.out.println("TuristickiPaketUpdating Aspect Initialized");
    }

    // Define a pointcut that matches the save and update operations for SpecijalnaPonuda
    @Pointcut("execution(* com.asss.pj.TuristickaAgencija.repo.SpecijalnaPonudaRepo.save(..))")
    public void saveSpecijalnaPonuda() {
    }

    @Pointcut("execution(* com.asss.pj.TuristickaAgencija.service.SpecijalnaPonudaServiceImpl.initializeSpecijalnaPonuda(..))")
    public void initializeSpecijalnaPonuda() {
    }
//
//    @After("execution(* com.asss.pj.TuristickaAgencija.service.SpecijalnaPonudaServiceImpl.save(..))")
//    public void logAfterSave() {
//        System.out.println("Aspect triggered after saving SpecijalnaPonuda.");
//    }
//
//    // After successfully saving or updating SpecijalnaPonuda, update the price of TuristickiPaket

    // fixme: ne radi
    @AfterReturning(pointcut = "saveSpecijalnaPonuda() || initializeSpecijalnaPonuda()", returning = "result")
    public void updateCenaAfterSavingSpecijalnaPonuda(Object result) {
        myLogger.info("Aspect triggered after saving SpecijalnaPonuda.");

        if (result instanceof SpecijalnaPonuda specijalnaPonuda) {
            TuristickiPaket turistickiPaket = specijalnaPonuda.getTuristickiPaket();
            if (turistickiPaket != null) {
                double price = turistickiPaket.getCena();
                double discount = specijalnaPonuda.getPopust();
                double updatedPrice = price * (100 - discount) / 100;

                // Update the price of the TuristickiPaket
                turistickiPaket.setCena(updatedPrice);
                turistickiPaketRepo.save(turistickiPaket);

                myLogger.info("Updated cena of TuristickiPaket with ID " + turistickiPaket.getId() +
                        " to " + updatedPrice + "\nThe procent of discount is " + discount + "%");
            }
        }
    }


}