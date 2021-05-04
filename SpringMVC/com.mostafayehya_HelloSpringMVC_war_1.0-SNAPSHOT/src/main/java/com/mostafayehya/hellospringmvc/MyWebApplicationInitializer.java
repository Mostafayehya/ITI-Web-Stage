/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.hellospringmvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author moust
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        XmlWebApplicationContext applicationContext
                = new XmlWebApplicationContext();

        applicationContext.setConfigLocation("/WEB-INF/spring/mvc.xml");

        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);

        ServletRegistration.Dynamic registration = servletContext.addServlet("mvc-dispatcher",
                dispatcherServlet);
        
        registration.setLoadOnStartup(1);
        registration.addMapping("*.htm");
       

    }

}
