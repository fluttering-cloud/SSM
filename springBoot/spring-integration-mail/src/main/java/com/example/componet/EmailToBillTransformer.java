package com.example.componet;

import com.example.pojo.Bill;


import org.springframework.integration.mail.transformer.AbstractMailMessageTransformer;
import org.springframework.integration.support.AbstractIntegrationMessageBuilder;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

//这是一个集成流的转换器，用于将账单邮件转换成邮件对象
@Component
public class EmailToBillTransformer extends AbstractMailMessageTransformer<Bill> {


    @Override
    protected AbstractIntegrationMessageBuilder<Bill> doTransform(Message message) throws Exception {
        Bill bill = processPayLoad(message);
        return MessageBuilder.withPayload(bill);
    }

    private Bill processPayLoad(Message message) {
    }
}
