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
public class Day2_0 {

    public static void main(String[] args) {


        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("day2/beans_0.xml");

        CustomerDao0 customerDao0 = context.getBean("customerDAO0", CustomerDao0.class);

        Customer newc = new Customer("adsfasd", 0);

        customerDao0.save(newc);

        customerDao0.findAll().forEach(customer -> {
            System.out.println(customer.name);
        });

    }

}
