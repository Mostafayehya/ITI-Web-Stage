/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author moust
 */
@Configuration
public class AppConfig1 {

    @Autowired
    AppConfig appconfig;
    @Bean("accountService3")
    public AccountService accountService3(AccountDao accountDao) {
        return new AccountServiceImpl(appconfig.accountDao());
    }

}
