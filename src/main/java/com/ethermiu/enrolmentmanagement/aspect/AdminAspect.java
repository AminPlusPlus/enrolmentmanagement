package com.ethermiu.enrolmentmanagement.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public class AdminAspect {

    @Around("execution(* com.ethermiu.enrolmentmanagement.controller.StudentController.*(..))")
    public Object transactionSafety(ProceedingJoinPoint call) {
        Object object = null;
        try {
            System.out.println("Running try catch for "+call.getSignature().getName());
            object = call.proceed();
        } catch(Throwable e){
            e.printStackTrace();
        }
        return object;
    }

}
