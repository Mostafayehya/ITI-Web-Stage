/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.day3;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author moust
 */
public class Factory {

    
    public  EntityManagerFactory getEntityManagerFactory(){
        
        String persistanceUnit = "customerPU";
        
        return Persistence.createEntityManagerFactory(persistanceUnit);
        
    }
    
}
