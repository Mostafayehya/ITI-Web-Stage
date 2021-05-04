/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.entities;

import com.mostafayehya.tests.day3.Mobile;

/**
 *
 * @author moust
 */
public class Account {
    
    String id;
    Double balance; 
    
    String name; 
    
    Mobile mobile ;
    
    public Account() {
    }

    public Account(String id, Double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Account(String name, Mobile mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public Account(String id, Double balance, String name, Mobile mobile) {
        this.id = id;
        this.balance = balance;
        this.name = name;
        this.mobile = mobile;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }
    


    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", balance=" + balance + '}';
    }
    
    public void display(){
        
        System.out.println("Account{" + "id=" + id + ", balance=" + balance + ", name=" + name + ", mobile=" + mobile +'}');
        
    }
    
    
    
    
    
}
