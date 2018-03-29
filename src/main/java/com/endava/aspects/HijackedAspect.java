package com.endava.aspects;

import com.endava.Application;
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

    @Pointcut("execution(* com.endava.services.*Service.*(..))")
    private void service() {
    }//

    @Pointcut("execution(* com.endava.services.*Repository.*(..))")
    private void repository() {
    }//


    @Before("execution(* com.endava.services.*Service.*(..))")
    public void doAccessCheck() {
        LOGGER.info("Check if you have access");

    }

    @After("execution(* com.endava.services.*Service.*(..))")
    public void cleanUp() {
        LOGGER.info("Clean up ");
    }

    @Around("execution(* com.endava.services.*Service.*(..))")
    public Object doSometingHereForService(ProceedingJoinPoint joinPoint) throws Throwable {
        //Continue or stop this ?
        LOGGER.info("Continue or stop this ?");
        return joinPoint.proceed();

    }

    @Around("execution(* com.endava.repository.*Repository.*(..))")
    public Object doSometingHereForRepository(ProceedingJoinPoint joinPoint) throws Throwable {
        //Continue or stop this ?
        LOGGER.info("Continue or stop this ?");
        return joinPoint.proceed();

    }
}
