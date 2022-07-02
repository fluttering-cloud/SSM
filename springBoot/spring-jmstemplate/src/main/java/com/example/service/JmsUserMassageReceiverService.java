package com.example.service;


import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.Objects;

@Service
public class JmsUserMassageReceiverService {

    private JmsTemplate jmsTemplate;
    @Autowired
    public void setJmsTemplate(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }


    private MessageConverter converter;

    @Autowired
    public void setConverter(MessageConverter converter) {
        this.converter = converter;
    }

    public User receiverUser(){
            return (User)jmsTemplate.receiveAndConvert("spring-jmstemplate.User.queue");
    }

    public User receiverUser(String destination) throws JMSException {
        Message message = jmsTemplate.receive(destination);
        return (User) converter.fromMessage(message);
    }
}
