/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.day2;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moust
 */
public class Day2_1 {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("day2/beans_1.xml");

        CustomerDao1 customerDao1 = context.getBean("customerDAO1", CustomerDao1.class);

        Customer newc = new Customer("templateOnlyUser", 1);
        
        customerDao1.save(newc);

        customerDao1.findAll().forEach(customer -> {
            System.out.println(customer.name);
        });

    }

}
