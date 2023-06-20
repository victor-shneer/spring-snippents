package com.carmel.springSnippents.customAnnotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeTrackerAdvice {

    Logger logger = LoggerFactory.getLogger(ExecutionTimeTrackerAdvice.class);
    @Around("@annotation(com.carmel.springSnippents.customAnnotation.TrackExecTime)")
    public Object trackTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long strTime = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("Method name " + proceedingJoinPoint.getSignature() + " time taken: " + (endTime - strTime));
        return proceed;
    }
}
