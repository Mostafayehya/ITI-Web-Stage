/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.services.impl;

import com.mostafayehya.services.FirstService;

/**
 *
 * @author moust
 */
public class FirstServiceImpl implements FirstService {

    private int age;
    private String name;

    public  FirstService createFirstServiceImpl() {
        return new FirstServiceImpl();
    }

    public static  FirstService createFirstServiceImpl(int age) {
        return new FirstServiceImpl(age);

    }
    public static  FirstService createFirstServiceImpl(int age,String name) {
        return new FirstServiceImpl(age,name);

    }

    public FirstServiceImpl() {

    }

    public FirstServiceImpl(int age) {
        this.age = age;
    }

    public FirstServiceImpl(String name) {
        this.name = name;
    }

    public FirstServiceImpl(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void displayFirstService() {

        System.out.println("The name is: " + name);
        System.out.println("The age is: " + age);
    }

}
