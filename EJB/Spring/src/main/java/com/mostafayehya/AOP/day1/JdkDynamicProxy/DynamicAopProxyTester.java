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
public class DynamicAopProxyTester {

    public static void main(String[] args) {

        CalculatorFactory calculatorFactory = CalculatorFactory.getInstance();

        System.out.println(calculatorFactory.getTarget().add(1, 1));
        System.out.println(calculatorFactory.getTargetWithAdvice().add(1, 1));
        System.out.println(calculatorFactory.getTargetWithAdvice().sub(1, 1));

    }

}
