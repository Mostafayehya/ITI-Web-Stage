/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.AOP.day1.ProxyBasedAop;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;

/**
 *
 * @author moust
 */
public class CalculatorAround implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {

        
        System.out.println("\nCalculator Around");
        System.out.println("======================");
        System.out.println("**********Before calling method using around*************");

        Object result = mi.proceed();

        System.out.println("**********After calling method using around*************");

        return result;

    }

}
