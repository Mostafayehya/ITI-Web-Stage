/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day4.inject;

import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;


@ManagedBean("accountService")
public class AccountServiceImpl implements AccountService {

    AccountDao accountDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    @Inject
    public void setAccountDao(@Named("qualifiedAccountDao")AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> fetchAllAccounts() {
        return accountDao.getAllAcounts();
    }

}
