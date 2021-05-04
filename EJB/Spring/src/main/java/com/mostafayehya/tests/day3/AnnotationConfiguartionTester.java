/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day3;

import com.mostafayehya.entities.Child;
import com.mostafayehya.entities.ComplexObject;
import com.mostafayehya.entities.User;
import com.mostafayehya.services.DAOService;
import com.mostafayehya.services.impl.DAOServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moust
 */
public class AnnotationConfiguartionTester {

    public static void main(String[] args) {

        ConfigurableApplicationContext context
                = new ClassPathXmlApplicationContext("day3/annotated_beans.xml");
        
        context.registerShutdownHook();

        System.out.println("\n=============Test @AutoWired over setter and over field with required attribute =================");

        DAOService daoService = (DAOService) context.getBean("daoService");
        daoService.printUser();
        daoService.printProduct();
        daoService.printAccounts();

        System.out.println("\n=============Test resolvable dependencies =================");

        DAOServiceImpl daoServiceImpl = (DAOServiceImpl) context.getBean("daoService");

        System.out.println(daoServiceImpl.environment.getActiveProfiles());

        System.out.println("\n=============Test Qualifier=================");

        User user = (User) context.getBean("user");

        System.out.println("Qualfified account injected insdie user = " + user.getAccount().toString());

        System.out.println("\n=============Test custom Qualifier=================");

        user.getAccount().display();

    }

}
