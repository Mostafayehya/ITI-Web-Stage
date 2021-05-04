/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day5;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *
 * @author moust
 */
public class AccountDaoImpl implements AccountDao {
    
    
    List<Account> accounts;

    @PostConstruct
    public void init() {
        accounts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            accounts.add(new Account("account #" + i + 1));
        }
    }

    @Override
    public List<Account> fetchAllAccounts() {
       
        return accounts;
    }

   
    
}
