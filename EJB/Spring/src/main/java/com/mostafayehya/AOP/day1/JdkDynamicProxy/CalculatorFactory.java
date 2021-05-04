/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.AOP.day1.JdkDynamicProxy;

import java.lang.reflect.Proxy;

/**
 *
 * @author moust
 */
public class CalculatorFactory {

    private final Calculator target;
    private final Calculator targetWithAdvice;

    private static CalculatorFactory INSTANCE;

    private CalculatorFactory() {

        target = new CalculatorImpl();

        CalculatorAdvice advice = new CalculatorAdvice();
        CalculatorProxy calculatorProxy = new CalculatorProxy(target, advice);

        // define proxy instance 
        Class[] interfaces = new Class[]{Calculator.class};

        targetWithAdvice = (Calculator) Proxy.newProxyInstance(new ClassLoader() {
        }, interfaces, calculatorProxy);

    }

    public static CalculatorFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CalculatorFactory();

        }

        return INSTANCE;
    }

    public Calculator getTarget() {
        return target;
    }

    public Calculator getTargetWithAdvice() {
        return targetWithAdvice;
    }

}
