/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.AOP.day1.JdkDynamicProxy;

/**
 *
 * @author moust
 */
public class CalculatorAdvice {
    
    public void before(double arg1,String operator,double arg2){
        System.out.println(arg1 + operator + arg2);
    }
    
    public void after(double result){
        System.out.println("result is :" + result);
    }
    
    public void afterThrowing(Exception exception){
        System.err.println(exception.getMessage());
    }
    
}
