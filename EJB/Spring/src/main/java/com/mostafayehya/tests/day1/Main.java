/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day1;

import com.mostafayehya.services.FirstService;
import com.mostafayehya.services.impl.FirstServiceFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moust
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("beans.xml");

        FirstService firstService = (FirstService) context.getBean("service1");
        FirstService firstService2 = (FirstService) context.getBean("service2");
        FirstService firstService3 = (FirstService) context.getBean("service3");
        FirstService firstService4 = (FirstService) context.getBean("service4");
        FirstService firstService5 = (FirstService) context.getBean("service5");
        FirstService firstService6 = (FirstService) context.getBean("service6");
        FirstService firstService7 = (FirstService) context.getBean("service7");
        // FirstService firstService8 = (FirstService) context.getBean("service8");

        System.out.println("========================================");
        System.out.println("First Service ");
        firstService.displayFirstService();

        System.out.println("========================================");
        firstService2.displayFirstService();

        System.out.println("========================================");
        firstService3.displayFirstService();

        System.out.println("========================================");
        firstService4.displayFirstService();

        System.out.println("========================================");
        firstService5.displayFirstService();

        System.out.println("========================================");
        firstService6.displayFirstService();

        System.out.println("========================================");
        firstService7.displayFirstService();

    }

}
