/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day2;

import com.mostafayehya.entities.Message;
import com.mostafayehya.entities.Seller;
import com.mostafayehya.tests.day1.*;
import com.mostafayehya.services.DAOService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moust
 */
public class CollectionBasedBeanTester {

    public static void main(String[] args) {

            ApplicationContext context
                    = new ClassPathXmlApplicationContext("day2/collection_beans.xml");

        Seller seller = (Seller) context.getBean("seller");

        // printing products
        System.out.println("printing products");
        System.out.println("============================");

        seller.getProducts().forEach((p) -> {
            System.out.println(p);
        });

        // printing phone numbers
        System.out.println("printing phone numbers");
        System.out.println("============================");
        seller.getPhoneNumbers().forEach((phoneNumber) -> {
            System.out.println(phoneNumber);
        });

        // printing Messages
        System.out.println("printing messages");
        System.out.println("============================");
        seller.getMessages().forEach((user, message) -> {
            System.out.println("User: " + user.getName() + " has message: " + message.getContent());
        });

        
        // Testing Null bean 
        System.out.println("Testing nullable messages");
        System.out.println("============================");
        Message messageBean = (Message) context.getBean("nullbean");

        if (messageBean.getContent() == null) {
            System.out.println("Message has a null content");
        }
    }

}
