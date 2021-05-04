/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iti.greenshop;

import java.io.Serializable;

/**
 *
 * @author ITI
 */

public class CreditCard implements Serializable{
    private int[] parts;

    public CreditCard(int part1,int part2,int part3,int part4) {
        this.parts = new int[4];
        this.parts[0] = part1;
        this.parts[1] = part2;
        this.parts[2] = part3;
        this.parts[3] = part4;
      
    }

//      public CreditCard() {
////        this.parts = new float[4];
////        this.parts[0] = p1;
////        this.parts[1] = p2;
////        this.parts[2] = p3;
////        this.parts[3] = p4;
//System.out.println("ana hena ------------------------------------------------");
//      
//    }
      
    public int[] getParts() {
        return parts;
    }

    public void setParts(int[] parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return parts[0]+"-"+parts[1]+"-"+parts[2]+"-"+parts[3];
    }
    
    
    
}
