/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.controller;

import com.mostafayehya.models.JmsMessageModel;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author moust
 */
@Named
@RequestScoped
public class JmsMessageController {

    @Inject
    private JmsMessageModel jmsMessageModel;

    @Resource(mappedName = "jms/myQueue") // note that I didn't find server queue, so I chosed request queue for this S
    private Queue myQueue;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    public String sendMsg() {

        sendJmsMessageToMyQueue(jmsMessageModel.getMsgText());
        return "confirmation";
    }

    private void sendJmsMessageToMyQueue(String msgData) {
        context.createProducer().send(myQueue, msgData);
    }

}
