/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day2;

import com.mostafayehya.entities.Message;
import com.mostafayehya.services.DAOService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moust
 */
public class BeanScopeTesting {

    public static void main(String[] args) {

        ApplicationContext context
                = new ClassPathXmlApplicationContext("day2/scoped_beans.xml");

        Message singletone = (Message) context.getBean("singletoneMesssage");
        Message prototype = (Message) context.getBean("prototypeMesssage");

        System.out.println("Singletone first reference : " + singletone.getContent());
        System.out.println("Prototype first referrnce : " + prototype.getContent());

        singletone.setContent("New Contnet added");
        Message singletone2 = (Message) context.getBean("singletoneMesssage");
        System.out.println("Singletone second reference : " + singletone2.getContent());

        prototype.setContent("new Content for prototype");
        Message prototype2 = (Message) context.getBean("prototypeMesssage");
        System.out.println("Prototype 2 referrnce : " + prototype2.getContent());

    }

}
