package com.asss.pj.TuristickaAgencija.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(4)
public class SpecijalnaPonudaLogging {

    private Logger myLogger = Logger.getLogger(getClass().getName());

        /*
            () - odgovara metodi bez argumenata
            (*) - odgovara metodi sa jednim argumentom bilo kog tipa
            (..) - odgovara metodi sa 0 ili vise argumenta bilo kog tipa
         */

    @Pointcut("execution(* com.asss.pj.TuristickaAgencija.service.SpecijalnaPonudaServiceImpl.findAll(..))")
    private void forFindAll() {

    }

    @Pointcut("execution(* com.asss.pj.TuristickaAgencija.service.SpecijalnaPonudaServiceImpl.findById(..))")
    private void forFindById() {

    }

    @Pointcut("execution(* com.asss.pj.TuristickaAgencija.service.SpecijalnaPonudaServiceImpl.save(..))")
    private void forSave() {

    }

    @Pointcut("execution(* com.asss.pj.TuristickaAgencija.service.SpecijalnaPonudaServiceImpl.deleteById(..))")
    private void forDeleteById() {

    }

    @Pointcut("forFindAll() || forFindById() || forSave() || forDeleteById()")
    private void forCrud() {

    }


    @Before("forCrud()")
    public void beforeMethod(JoinPoint theJoinPoint) {// JoinPoint ima metapodatke o metodi koja je pozvana

            /*
                JoinPoint je koncept koji predstavlja određenu tačku tokom izvršavanja programa,
                kao što je poziv metode ili pristup polju. Omogućava aspektima da se zalažu na ovim tačkama i izvrše
                dodatno ponašanje, poznato kao aspect.
             */

        // display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @Before: calling method: " + theMethod);

        // display the arguments to the method

        // get the arguments
        Object[] args = theJoinPoint.getArgs();

        // loop through and display args
        for (Object tempArg : args) {
            myLogger.info("argument: " + tempArg);
        }
    }

    @AfterReturning(
            pointcut = "forCrud()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

        // display method we are returning from
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @AfterReturning: from method: " + theMethod);

        // display data returned
        myLogger.info("=====>> result: " + theResult);
    }
}