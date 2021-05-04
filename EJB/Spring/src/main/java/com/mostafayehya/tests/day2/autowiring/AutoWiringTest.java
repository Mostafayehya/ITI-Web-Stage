/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day2.autowiring;

import com.mostafayehya.entities.Seller;
import com.mostafayehya.services.DAOService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moust
 */
public class AutoWiringTest {
    
    public static void main(String[] args) {
        
           ApplicationContext context
                    = new ClassPathXmlApplicationContext("day2/autowiring_beans.xml");

        DAOService daoService = (DAOService) context.getBean("daoService");
        
        daoService.printProduct();
        daoService.printUser();
    }
         
    
}
