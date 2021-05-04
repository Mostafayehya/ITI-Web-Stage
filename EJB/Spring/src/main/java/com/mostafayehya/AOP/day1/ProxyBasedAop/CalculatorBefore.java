 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.AOP.day1.ProxyBasedAop;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.springframework.aop.MethodBeforeAdvice;

/**
 *
 * @author moust
 */
public class CalculatorBefore implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] os, Object o) throws Throwable {
        
        System.out.println("\nBefore adivce");
        System.out.println("====================================");
        
        System.out.println("Method name: " + method.getName());
        System.out.println("Method arguments: " + Arrays.toString(os));
    }
    
}
