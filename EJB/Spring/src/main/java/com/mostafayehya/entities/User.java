/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.entities;

import com.mostafayehya.tests.day3.AccountQualifier;
import com.mostafayehya.tests.day3.Mobile;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author moust
 */
public class User {

    String name;

    @Autowired
    @AccountQualifier(name = "Yehya", mobile = Mobile.Etisalat)
    Account account;

    public User() {
    }

    @PostConstruct
    public void init() {

        System.out.println("--------------------Init by @PostConstruct was called----------------------------");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("--------------------destroy by @PreDestroy was called----------------------------");

    }

    public User(String name) {
        this.name = name;
    }

    public User(String firstName, String lastName) {
        this.name = firstName + lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + '}';
    }

}
