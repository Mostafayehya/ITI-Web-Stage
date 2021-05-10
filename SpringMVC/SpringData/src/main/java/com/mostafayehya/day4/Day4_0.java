/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.day4;

import java.awt.print.Pageable;
import java.util.Iterator;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moust
 */
public class Day4_0 {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("day4/beans_0.xml");

        CustomerCrudRepository customerDao = (CustomerCrudRepository) context.getBean("customerCrudRepository");

        Customer newc = new Customer("Repository custmer", 24);

        customerDao.save(newc);

        Iterable iterable = customerDao.findAll();
        Iterator iterator = iterable.iterator();

        System.out.println("\n========== =============");

        while (iterator.hasNext()) {
            Customer customer1 = (Customer) iterator.next();
            System.out.println(customer1);
        }

        System.out.println("====" + customerDao.findById(newc.getId()));

        System.out.println("newc already exists? " + customerDao.existsById(newc.getId()));

        System.out.println("\n==========  test Count by name and Age =============");
        System.out.println("countByNameAndAge(\"Repository custmer\", 24) = " + customerDao.countByNameAndAge("Repository custmer", 24));

        System.out.println("\n==========  test Count by name  =============");

        System.out.println("countByName(Repository custmer) = " + customerDao.countByName("Repository custmer"));

        System.out.println("\n==========  test Count by name  =============");

        System.out.println("countByName(Repository custmer) = " + customerDao.countByName("Repository custmer"));

        System.out.println("\n==========  test findCustomerByIdGreaterThan(int id)  =============");

        customerDao.findCustomerByIdGreaterThan(1).forEach(cus -> {
            System.out.println(cus.toString());
        });
        System.out.println("\n========== findDistinctCustomerByAge(int age)  =============");

        customerDao.findDistinctCustomerByAge(5).forEach(cus -> {
            System.out.println(cus.toString());
        });
        System.out.println("\n==========  test findByNameIgnoreCase(String name)  =============");

        customerDao.findByNameIgnoreCase("repository Custmer").forEach(cus -> {
            System.out.println(cus.toString());
        });

        System.out.println("\n==========  test findByNameOrderByNameAsc(String name)  =============");

        customerDao.findByNameOrderByNameAsc("Repository custmer").forEach(cus -> {
            System.out.println(cus.toString());
        });
        System.out.println("\n========== findByAgeOrderByAgeDesc(0) =============");

        customerDao.findByAgeOrderByAgeDesc(0) .forEach(cus -> {
            System.out.println(cus.toString());
        });
        
        
        System.out.println("\n========== Testing annotated methods with native query =============");

        customerDao.findByNameNavtive("Repository custmer").forEach(cus -> {
            System.out.println(cus.toString());
        });
        System.out.println("\n========== Testing updateCustomer(55,yehya,9) =============");

        customerDao.updateCustomer(55,"yehya", 9);
        


    }

}
