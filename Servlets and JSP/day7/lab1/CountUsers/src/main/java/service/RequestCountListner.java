/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

/**
 *
 * @author moust
 */
public class RequestCountListner implements ServletRequestListener {
    
        
    public void requestInitialized(ServletRequestEvent sre){
        
        if(sre.getServletContext().getAttribute("pageHits") != null){
             int currentHits =(int)sre.getServletContext().getAttribute("pageHits");
             currentHits++;
              sre.getServletContext().setAttribute("pageHits",currentHits);

        }else{
             sre.getServletContext().setAttribute("pageHits",0);

        }
        
    }
  
    
}
