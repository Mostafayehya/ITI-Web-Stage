/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.day3;

import com.mostafayehya.day2.Customer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moust
 */
public class Day3_0 {

    public static void main(String[] args) {


        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("day3/beans_0.xml");

        CustomerDao0 customerDao0 = context.getBean("customerDAO0", CustomerDao0.class);

        Customer newc = new Customer("EneitytManger Customer", 0);

        customerDao0.save(newc);

        customerDao0.findAll().forEach(customer -> {
            System.out.println(customer.getName());
        });

    }

}
