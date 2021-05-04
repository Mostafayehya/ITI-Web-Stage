/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.tests.day5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author moust
 */
@Configuration
@Import(AppConfig1.class)
@ImportResource("day5/beans.xml")
@ComponentScan(basePackages = "com.mostafayehya.tests.day5")
public class AppConfig {

    @Bean(initMethod = "init", destroyMethod = "cleanup", name = {"account1", "accountOne"})
    public Account account1() {
        return new Account();
    }

    @Bean(name = "account2")
    public Account account2() {
        return new Account("this is account info");
    }

    @Bean
    @Scope("prototype")
    public AccountService accountService() {
        return new AccountServiceImpl(accountDao());
    }

    @Bean
    public AccountDao accountDao() {
        return new AccountDaoImpl();
    }

    @Bean
    public AccountService accountService1() {
        return new AccountServiceImpl(accountDao());
    }

//    This will retrive the same bean again from cache
    @Bean
    public AccountService accountService2() {
        return new AccountServiceImpl(accountDao());
    }

    @Value("${account.info}")
    private String accountInfo;
  
    @Bean(name = "propertiesAccount")
    public Account account3() {
        return new Account(accountInfo);
    }

}
