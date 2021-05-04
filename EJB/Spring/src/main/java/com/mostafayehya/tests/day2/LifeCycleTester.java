/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day2;

import com.mostafayehya.entities.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moust
 */
public class LifeCycleTester {

    public static void main(String[] args) {
        ConfigurableApplicationContext context
                = new ClassPathXmlApplicationContext("day2/life_cycled_beans.xml");

        context.registerShutdownHook();
        Message singletone = (Message) context.getBean("singletoneMesssage");
        Message prototype = (Message) context.getBean("prototypeMesssage");
        
        prototype = null;
    }

}
