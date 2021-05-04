/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.services.impl;

import com.mostafayehya.entities.Account;
import com.mostafayehya.services.DAOService;
import com.mostafayehya.services.ProductDAO;
import com.mostafayehya.services.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.core.env.Environment;

/**
 *
 * @author moust
 */
public class DAOServiceImpl implements DAOService {

    ProductDAO productDAO;
    UserDAO userDAO;
    @Qualifier("userDAO2")
    UserDAO userDAO2;

    @Autowired
    Account[] accounts;
    
    @Autowired
    public Environment environment;

    public DAOServiceImpl() {
    }

    @Autowired
    public void setup(ProductDAO productDAO, UserDAO userDAO) {

        System.out.println("From inside the setup method");
        this.productDAO = productDAO;
        this.userDAO = userDAO;
    }

    public DAOServiceImpl(ProductDAO productDAO) {
        System.out.println("public DAOServiceImpl(ProductDAO productDAO) was called");
        this.productDAO = productDAO;
    }

    public DAOServiceImpl(ProductDAO productDAO, UserDAO userDAO) {
        System.out.println("public DAOServiceImpl(ProductDAO productDAO, UserDAO userDAO) was called");

        this.productDAO = productDAO;
        this.userDAO = userDAO;
    }

    @Override
    public void daoServiceMethod() {

        System.out.println("From DAOServieImpl Method....");
    }

    @Override
    public void printProduct() {
        productDAO.productDAOMethod();
    }

    @Override
    public void printUser() {

        userDAO.userDAOMethod();
    }

    public void setProductDAO(ProductDAO productDAO) {
        System.out.println("public void setProductDAO(ProductDAO productDAO) was called ");

        this.productDAO = productDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        System.out.println("public void setUserDAO(UserDAO userDAO) was called");

        this.userDAO = userDAO;
    }

    @Override
    public void printAccounts() {

        for (Account account : accounts) {
            System.out.println(account.toString());
        }

    }

}
