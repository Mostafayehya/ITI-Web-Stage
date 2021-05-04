/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.AOP.day2;


public class MinCalculatorImpl implements MinCalculator {

    @Override
    public double min(double arg0, double arg1) {
        
        double result = (arg0 <=arg1)? arg0: arg1;
        
        System.out.println("\nMin =" + result);
        
        return result;
    }
    
}
