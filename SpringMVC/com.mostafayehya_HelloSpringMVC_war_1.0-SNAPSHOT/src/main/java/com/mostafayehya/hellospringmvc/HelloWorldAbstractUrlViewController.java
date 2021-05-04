/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.hellospringmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.AbstractUrlViewController;
import org.springframework.web.util.UrlPathHelper;

/**
 *
 * @author moust
 */
    public class HelloWorldAbstractUrlViewController extends AbstractUrlViewController {

 

    @Override
    protected String getViewNameForRequest(HttpServletRequest hsr) {
            String viewName=null;
            
            String requestPath = new UrlPathHelper().getPathWithinApplication(hsr);
            
            System.out.println(requestPath);
            
            if(requestPath.equals("/hello2.htm")){
                viewName="HelloWorldPage2";
            }
            
            return viewName;    }

}
