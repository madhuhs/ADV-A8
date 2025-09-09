package com.jspiders.pms.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GlobalExceptionHandler {

    // Pointcut for all service methods
    @Pointcut("execution(* com.jspiders.pms.service.*.*(..))")
    public void serviceMethods() {
    }
    @AfterThrowing(pointcut = "serviceMethods()", throwing = "ex")
    public void handleException(JoinPoint joinPoint,Exception ex){
        System.out.println("handling Exception");
        System.out.println(ex.getMessage());
    }
}
