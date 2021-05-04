/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day4;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Repository;

/**
 *
 * @author moust
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    List<Account> accounts;

    @PostConstruct
    public void init() {
        accounts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            accounts.add(new Account("account #" + i + 1));
        }

        System.out.println("\n--------------------------");
        System.out.println("Init was called for AccountDaoImpl ");
        System.out.println("--------------------------\n");

    }

    @PreDestroy
    public void destroy() {
        System.out.println("\n--------------------------");
        System.out.println("destroy was called for AccountDaoImpl ");
        System.out.println("--------------------------\n");

    }

    @Override
    public List<Account> getAllAcounts() {
        
        return accounts;
    }

}
