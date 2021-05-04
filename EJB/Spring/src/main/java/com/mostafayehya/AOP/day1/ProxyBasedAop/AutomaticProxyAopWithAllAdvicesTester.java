/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.AOP.day1.ProxyBasedAop;

import com.mostafayehya.AOP.day1.JdkDynamicProxy.Calculator;
import com.mostafayehya.AOP.day1.JdkDynamicProxy.CalculatorImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moust
 */
public class AutomaticProxyAopWithAllAdvicesTester {
    
    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("aop/day1/auto_proxy_all_advices_beans.xml");
        
       Calculator calc= context.getBean("userCalc",Calculator.class);
      
        System.out.println(calc.add(5, 6));
        System.out.println(calc.sub(5, 6));
        System.out.println(calc.mul(5, 6));
        System.out.println(calc.div(6, 6));
        System.out.println(calc.div(5, 5));
       
    }
    
}
