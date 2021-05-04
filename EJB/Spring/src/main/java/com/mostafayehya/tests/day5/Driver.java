/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author moust
 */
public class Driver {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class, ModelConfig.class);

        context.registerShutdownHook();

        Account account1 = (Account) context.getBean("account1");
        Account accountOne = (Account) context.getBean("accountOne");
        Account account2 = (Account) context.getBean("account2");

        System.out.println("First account bean info :" + account1.getInfo());
        System.out.println("Second account bean info :" + account2.getInfo());

        System.out.println("account1 == accountOne?: " + (account1 == accountOne));

        System.out.println("---------Testing import -------------");

        AccountService accountservice = (AccountService) context.getBean("accountService3");
        accountservice.fetchAllAccounts().forEach(account -> {
            System.out.println(account.getInfo());
        });

        System.out.println("---------Testing properties based account -------------");

        Account propertiesBasedAccount = (Account) context.getBean("propertiesAccount");
        
        System.out.println("Properties based account info :" + propertiesBasedAccount);
              

    }

}
