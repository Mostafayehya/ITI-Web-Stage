 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.AOP.day1.ProxyBasedAop;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 *
 * @author moust
 */
public class CalculatorAfterReturning implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] os, Object target) throws Throwable {
        
          
        System.out.println("\nAfter Returning advice");
        System.out.println("====================================");
        
        System.out.println("Method return: " + returnValue);
        System.out.println("Method name: " + method.getName());
        System.out.println("Method arguments: " + Arrays.toString(os));
    }


    
}
