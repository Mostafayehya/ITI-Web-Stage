/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.AOP.day2;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 *
 * @author moust
 */
@Aspect
public class CalculatorAfter {
    
    @After("execution(* com.mostafayehya.AOP..sub(..))")
    public void before(JoinPoint joinPoint){
        
        System.out.println("The method: " + joinPoint.getSignature().getName()  );
        System.out.println("The arguments: " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("After your service method");
    }
    
}
