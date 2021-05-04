/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.entities;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 *
 * @author moust
 */
public class Message implements InitializingBean, DisposableBean {

    String content;

    public Message() {
    }

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void destroy() throws Exception {

        System.out.println("\n************************");
        System.out.println("Hello from destroy caused by implementing DisposableBean interface");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("\n************************");
        System.out.println("afterPropertiesSet was called (implementing InitializingBean interface) ");

    }

    public void init() {
        System.out.println("\n************************");
        System.out.println("Hello from init method  ( Generic initialization method)");
    }

    public void kill() {
        System.out.println("\n************************");
        System.out.println("Hello from kill (Generic destruction method)");
    }

}
