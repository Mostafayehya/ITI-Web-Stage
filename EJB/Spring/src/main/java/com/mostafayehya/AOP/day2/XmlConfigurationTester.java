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
public class XmlConfigurationTester {

    public static void main(String[] args) {

        ApplicationContext context
                = new ClassPathXmlApplicationContext("aop/day2/aspects-xml.xml");

        Calculator calculator = (Calculator) context.getBean("calc");

        System.out.println("============Calling cal.add()==============");
        System.out.println(calculator.add(5, 5));


    }

}
