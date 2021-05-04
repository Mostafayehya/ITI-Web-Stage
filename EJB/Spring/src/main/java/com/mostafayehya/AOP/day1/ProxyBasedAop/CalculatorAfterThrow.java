/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.AOP.day1.ProxyBasedAop;

import org.springframework.aop.ThrowsAdvice;

/**
 *
 * @author moust
 */
public class CalculatorAfterThrow implements ThrowsAdvice {

    public void afterThrowing(IllegalArgumentException exception) throws Throwable {

        System.out.println("\nCalculator Throws");
        System.out.println("==========================");
        System.err.println("\nIllegal arguments......");

    }

}
