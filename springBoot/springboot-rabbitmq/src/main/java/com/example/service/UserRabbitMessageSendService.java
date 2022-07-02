package com.example.service;

import com.example.pojo.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;


import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserRabbitMessageSendService {

    private RabbitTemplate rabbitTemplate;
    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendUser(User user){
        MessageConverter converter = rabbitTemplate.getMessageConverter();
        MessageProperties messageProperties = new MessageProperties();
        Message message = converter.toMessage(user, messageProperties);
        rabbitTemplate.send(message);
    }

    public void sendUser(User user,String destination){
        rabbitTemplate.convertAndSend(destination,user);
    }
}
