/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.AOP.day2;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

/**
 *
 * @author moust
 */
@Aspect
@Order(1)
public class CalculatorBefore {
    
    @Before("CalculatorAspect.addOperation()")
    public void before(JoinPoint joinPoint){
        
        System.out.println("The method: " + joinPoint.getSignature().getName()  );
        System.out.println("The arguments: " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Before your service method");
    }
    
}
