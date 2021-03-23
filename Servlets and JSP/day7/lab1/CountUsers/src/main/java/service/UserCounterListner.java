/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 *
 * @author moust
 */
public class UserCounterListner implements HttpSessionListener {

    int counter =0; 
    public void sessionCreated(HttpSessionEvent hse) {
        System.out.println("Session created.");
        
        incrementUserCounter();
        System.out.println(counter);
        hse.getSession().getServletContext().setAttribute("userCount", counter);        
     
    }

    public void sessionDestroyed(HttpSessionEvent hse) {
        System.out.println("Session destroyed.");
        decrementUserCounter();
        
        System.out.println(counter);
        
        hse.getSession().getServletContext().setAttribute("userCount",counter);        

    }   

    private void incrementUserCounter() {
        counter ++; 
    }

    private void decrementUserCounter() {
        
        counter--; 
    }

}
