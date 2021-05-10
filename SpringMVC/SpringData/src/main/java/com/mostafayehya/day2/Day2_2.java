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
public class Day2_2 {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("day2/beans_2.xml");

        CustomerDao2 customerDao2 = context.getBean("customerDAO2", CustomerDao2.class);

        Customer newc = new Customer("hibernateTemplate+TransactionTemplate_User", 3);
        
        customerDao2.save(newc);

        customerDao2.findAll().forEach(customer -> {
            System.out.println(customer.name);
        });

    }

}
