package com.example.Componet;

import com.example.pojo.User;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import java.util.HashMap;
import java.util.Map;

@Component
public class JmsComponents {

    //配置消息发送的目的地，若不配置，则使用默认的目的地
    @Bean
    public Destination userQueue(){
        return new ActiveMQQueue("spring-jmstemplate.User.queue");
    }

    //配置消息转换器
    @Bean
    public MappingJackson2MessageConverter messageConverter(){
        //创建消息转换器对象
        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
        //声明传递消息的类型，让接收者知道传入的消息要转换成什么类型
        messageConverter.setTypeIdPropertyName("_typeId");
        //设置消息类型映射关系
        Map<String,Class<?>> typeIdMappings = new HashMap<>();
        typeIdMappings.put("user", User.class);
        //加载消息映射关系
        messageConverter.setTypeIdMappings(typeIdMappings);
        //将信消息转换器注入容器
        return messageConverter;
    }




}
