/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day2;

import com.mostafayehya.entities.compound.BigBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moust
 */
public class CompoundPropertyNameTester {
    
   
    
    public static void main(String[] args) {
        
         ApplicationContext context
                = new ClassPathXmlApplicationContext("day2/compound_prop_beans.xml");
         
         BigBean bigbean = (BigBean) context.getBean("bigbean");
         
         System.out.println("===================================");
         System.out.println(bigbean.getSubBean1().getSubBean2().getName());
        
    }
    
}
