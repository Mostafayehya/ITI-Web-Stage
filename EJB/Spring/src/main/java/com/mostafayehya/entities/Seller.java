/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.entities;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author moust
 */
public class Seller {
    
    List products; 
    Set phoneNumbers;
    Map<User,Message> messages;
    
    List<String> emails;

    public Seller() {
    }


    public Seller(List products, List<String> emails) {
        this.products = products;
        this.emails = emails;
    }

    public List getProducts() {
        return products;
    }

    public void setProducts(List products) {
        this.products = products;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public Set getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Map<User, Message> getMessages() {
        return messages;
    }

    public void setMessages(Map<User, Message> messages) {
        this.messages = messages;
    }

    
    
}
