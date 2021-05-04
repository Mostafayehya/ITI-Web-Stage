/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day4.inject;


/**
 *
 * @author moust
 */
public class Account {
    
    String info;

    public Account() {
    }

    public Account(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Account{" + "info=" + info + '}';
    }
    
    
    
    
    
}
