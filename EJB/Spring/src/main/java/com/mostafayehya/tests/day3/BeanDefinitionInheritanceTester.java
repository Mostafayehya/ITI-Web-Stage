/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day3;

import com.mostafayehya.entities.Child;
import com.mostafayehya.entities.ComplexObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moust
 */
public class BeanDefinitionInheritanceTester {

    public static void main(String[] args) {

        ApplicationContext context
                = new ClassPathXmlApplicationContext("day3/beans.xml");

        Child child = (Child) context.getBean("child");
        System.out.println(child.toString());

        System.out.println("\n=============Test parent without class and abstract =================");

        Child child2 = (Child) context.getBean("child2");
        System.out.println(child2.toString());

        System.out.println("\n=============Testing LIST merging between child and parent =================");

        ComplexObject child3 = (ComplexObject) context.getBean("child3");

        child3.print();
        System.out.println("\n=============Testing SET merging between child and parent =================");

        ComplexObject child4 = (ComplexObject) context.getBean("child4");
        System.out.println(child4.toString());

        System.out.println("\n=============Testing PropertyPlaceHolderConfigurer =================");
        
        Child propertiesBasedChild = (Child) context.getBean("childWithExternalProperties");
      
        System.out.println(propertiesBasedChild.toString());
        
        

    }

}
