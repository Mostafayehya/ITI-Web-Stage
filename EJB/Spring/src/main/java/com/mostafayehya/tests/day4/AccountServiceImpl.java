/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day4;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("singleton")
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    AccountDao accountDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    @Resource
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> fetchAllAccounts() {
        return accountDao.getAllAcounts();
    }

}
