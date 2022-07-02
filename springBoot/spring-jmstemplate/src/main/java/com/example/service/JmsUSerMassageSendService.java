package com.example.service;

import com.example.pojo.User;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.HashMap;
import java.util.Map;

@Service
public class JmsUSerMassageSendService {

    //获取异步消息发送对象
    private JmsTemplate jmsTemplate;
    @Autowired
    public void setJmsTemplate(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }

    //获取发送消息的目的地
    private Destination userDestination;
    @Autowired
    public void setUserDestination(Destination userDestination) {
        this.userDestination = userDestination;
    }

    public void sendUser(User user){
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(user);
            }
        });
    }

    public void convertAndSendUser(User user){
        jmsTemplate.convertAndSend("spring-jmstemplate.User.queue",user);
    }

}
