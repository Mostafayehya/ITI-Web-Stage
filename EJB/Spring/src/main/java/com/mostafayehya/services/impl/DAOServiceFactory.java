/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.services.impl;

import com.mostafayehya.services.DAOService;
import com.mostafayehya.services.ProductDAO;
import com.mostafayehya.services.UserDAO;

/**
 *
 * @author moust
 */
public class DAOServiceFactory {
    
    public DAOService createDAOService(ProductDAO productDAO){
        return new DAOServiceImpl(productDAO);
    }
    
    public DAOService createDAOService(ProductDAO productDAO,UserDAO userDAO){
        return new DAOServiceImpl(productDAO,userDAO);
    }
    
}
