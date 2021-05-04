/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.AOP.day2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moust
 */
public class AspectJDriver {

    public static void main(String[] args) {

        ApplicationContext context
                = new ClassPathXmlApplicationContext("aop/day2/beans.xml");

        Calculator calculator = (Calculator) context.getBean("calc");

        System.out.println("============Calling cal.add()==============");
        System.out.println(calculator.add(5, 5));

        System.out.println("============Calling cal.sub()==============");
        System.out.println(calculator.sub(5, 5));

        System.out.println("============Calling cal.mul()==============");
        System.out.println(calculator.mul(5, 5));

        System.out.println("============Calling cal.div()==============");
        System.out.println(calculator.div(5, 5));

        System.out.println("\n\n ==================Testing introduction behaviours===================");

        MaxCalculator maxCalculator = (MaxCalculator) calculator;

        System.out.println("max(5,2)=" + maxCalculator.max(5, 2));

        MinCalculator minCalculator = (MinCalculator) calculator;

        System.out.println("min(5,2)=" + minCalculator.min(5, 2));
        
        CalculatorImpl impl = new CalculatorImpl();

    }

}
