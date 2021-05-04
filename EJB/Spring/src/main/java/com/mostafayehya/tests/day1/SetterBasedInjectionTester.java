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
public class SetterBasedInjectionTester {

    
    public static void main(String[] args) {
        
        ApplicationContext context
            = new ClassPathXmlApplicationContext("setter_based_beans_injection.xml");

    DAOService daoService = (DAOService) context.getBean("daoService");

    daoService.printProduct();
    daoService.printUser();
        
    }
    
   
    
  

}
