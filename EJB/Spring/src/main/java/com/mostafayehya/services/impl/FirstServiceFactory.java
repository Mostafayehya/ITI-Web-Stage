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
public class FirstServiceFactory {
    
    public FirstService createFristSeriveImpl(){
        return new FirstServiceImpl();
    }
    
    public static FirstService createFristSeriveImpl(int age){
        return new FirstServiceImpl(age);
                
    }
    public static FirstService createFristSeriveImpl(String message){
        return new FirstServiceImpl(message);
                
    }
    
     public  FirstService createFristSeriveImpl(int age,String name){
        return new FirstServiceImpl(age,name);
    }
    
}
