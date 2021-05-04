/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day1;

import com.mostafayehya.services.DAOService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moust
 */
public class FactoryBasedInjectionTester {
    
    public static void main(String[] args) {
        
                //Constructor based injection        
        ApplicationContext context
                = new ClassPathXmlApplicationContext("factory_based_injected_beans.xml");
        
                DAOService daoService = (DAOService) context.getBean("daoService");

        daoService.printProduct();
        daoService.printUser();

        
    }
       
    
}
