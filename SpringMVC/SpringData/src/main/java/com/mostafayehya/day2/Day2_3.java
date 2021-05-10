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
public class Day2_3 {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("day2/beans_3.xml");

        CustomerDao3 customerDao3 = context.getBean("customerDAO3", CustomerDao3.class);

        Customer newc = new Customer("hibernateTemplateAnd@Transactional_User", 3);
        
        customerDao3.save(newc);

        customerDao3.findAll().forEach(customer -> {
            System.out.println(customer.name);
        });

    }

}
