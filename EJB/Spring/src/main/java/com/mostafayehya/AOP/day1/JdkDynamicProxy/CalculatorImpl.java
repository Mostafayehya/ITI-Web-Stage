/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.AOP.day1.JdkDynamicProxy;

public class CalculatorImpl implements Calculator {

    @Override
    public double add(double arg1, double arg2) {

        double result = arg1 + arg2;
        return result;
    }

    @Override
    public double sub(double arg1, double arg2) {
        double result = arg1 - arg2;
        return result;
    }

    @Override
    public double mul(double arg1, double arg2) {

        double result = arg1 * arg2;
        return result;
    }

    @Override
    public double div(double arg1, double arg2) {

        if (arg2 == 0.0) 
            throw new IllegalArgumentException("--------Can't pass Zero as a divider---------");
        
        double result = arg1 / arg2;
        return result;
    }

}
