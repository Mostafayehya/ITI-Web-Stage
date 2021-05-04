/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.AOP.day2;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 *
 * @author moust
 */
@Aspect
public class CalculatorAfterThrow {

    @AfterThrowing(pointcut = "execution(* com.mostafayehya.AOP..div(..))")
    public void afterThrowing(JoinPoint joinPoint) throws Throwable {

        System.out.println("The method: " + joinPoint.getSignature().getName());
        System.out.println("The arguments: " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Before your service method");

        System.err.println("Exception.....");
    }

    @AfterThrowing(pointcut = "execution(* com.mostafayehya.AOP..div(..))",throwing = "exception")
    public void afterThrowing(IllegalArgumentException exception) throws Throwable {

        System.err.println("Illegal arguments.....");
    }

    @AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) throws Throwable {

        System.out.println("The method: " + joinPoint.getSignature().getName());
        System.out.println("The arguments: " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Afterthrow your service method");

        System.err.println("Illegal arguemnts.....");
    }

}
