/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springSecurity.day2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL
 */
@Controller
public class HelloController {

    @RequestMapping(value = {"/", "/user"}, method = RequestMethod.GET)
    protected ModelAndView welcomePage() {

        ModelAndView model = new ModelAndView("HelloWorldPage");
        model.addObject("msg", "Welcome to my app");
        model.addObject("title", "Home Page");
        model.setViewName("Homepage");
        return model;
    }
    
    

    @RequestMapping(value = {"/admin/home"}, method = RequestMethod.GET)
    protected ModelAndView adminPage() {

        ModelAndView model = new ModelAndView("securePage");
        model.addObject("title", "spring security ");
        model.addObject("msg", "this is protocted page! ");
        model.setViewName("adminpage");
        return model;

    } 
    
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView productsPage()
    {
          ModelAndView model = new ModelAndView("ProductsPage");
        model.addObject("title", "my Products ");
        model.setViewName("products");
        return model;
    }
}
