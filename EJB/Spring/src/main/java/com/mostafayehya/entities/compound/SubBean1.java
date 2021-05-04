/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.entities.compound;

/**
 *
 * @author moust
 */
public class SubBean1 {
    
    SubBean2 subBean2; 

    public SubBean1(SubBean2 subBean2) {
        this.subBean2 = subBean2;
    }

    public SubBean1() {
    }

    public SubBean2 getSubBean2() {
        return subBean2;
    }

    public void setSubBean2(SubBean2 subBean2) {
        this.subBean2 = subBean2;
    }
    
    
    
}
