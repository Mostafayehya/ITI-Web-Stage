/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day5;

import java.util.List;
import javax.annotation.Resource;

/**
 *
 * @author moust
 */
public class AccountServiceImpl implements AccountService {

    AccountDao accountDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    
    

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> fetchAllAccounts() {
        
        return accountDao.fetchAllAccounts();
    }

   
}
