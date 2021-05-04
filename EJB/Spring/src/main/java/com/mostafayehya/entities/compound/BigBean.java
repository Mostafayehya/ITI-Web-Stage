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
public class BigBean {
    
    
    
    SubBean1 subBean1;

    public BigBean() {
    }

    public BigBean(SubBean1 subBean1) {
        this.subBean1 = subBean1;
    }

    public SubBean1 getSubBean1() {
        return subBean1;
    }

    public void setSubBean1(SubBean1 subBean1) {
        this.subBean1 = subBean1;
    }
    
    
    
}
