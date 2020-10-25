package com.awysocki.caloriecalculator.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * This class contains SpringAOP (using AspectJ) settings
 */
@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Before("execution(public void com.awysocki.caloriecalculator.service.UserServiceImpl.save(..))")
    public void beforeRegisteringNewUserAccount() {

        logger.info("CREATING NEW USER ACCOUNT");

    }
}
