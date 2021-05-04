
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day4.inject;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moust
 */
public class JSR330AnnotationsTester {

    public static void main(String[] args) {

        ConfigurableApplicationContext context
                = new ClassPathXmlApplicationContext("day4/inject/beans.xml");

//        AccountService accountService = (AccountService) context.getBean(AccountService.class);
        AccountService accountService = (AccountService) context.getBean("accountService");

        accountService.fetchAllAccounts().forEach(account -> {

            System.out.println(account.toString());
        });

    }

}
