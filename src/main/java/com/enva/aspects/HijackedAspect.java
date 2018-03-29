package com.enva.aspects;

import com.enva.Application;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HijackedAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Pointcut("execution(* *(..))")
    private void anyPublicOperation() {
    }

    @Pointcut("execution(* com.enva.services.*Service.*(..))")
    private void service() {
    }//

    @Pointcut("execution(* com.enva.services.*Repository.*(..))")
    private void repository() {
    }//


    @Before("execution(* com.enva.services.*Service.*(..))")
    public void doAccessCheck() {
        LOGGER.info("Check if you have access");

    }

    @After("execution(* com.enva.services.*Service.*(..))")
    public void cleanUp() {
        LOGGER.info("Clean up ");
    }

    @Around("execution(* com.enva.services.*Service.*(..))")
    public Object doSometingHereForService(ProceedingJoinPoint joinPoint) throws Throwable {
        //Continue or stop this ?
        LOGGER.info("Continue or stop this ?");
        return joinPoint.proceed();

    }

    @Around("execution(* com.enva.repository.*Repository.*(..))")
    public Object doSometingHereForRepository(ProceedingJoinPoint joinPoint) throws Throwable {
        //Continue or stop this ?
        LOGGER.info("Continue or stop this ?");
        return joinPoint.proceed();

    }

    @Around("anyPublicOperation()")
    public Object doSometingHere(ProceedingJoinPoint joinPoint) throws Throwable {
        //Continue or stop this ?
        LOGGER.info("Continue or stop this for any public operation?");
        return joinPoint.proceed();
    }
}
