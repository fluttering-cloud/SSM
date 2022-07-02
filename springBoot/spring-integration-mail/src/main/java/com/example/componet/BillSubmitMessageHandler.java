package com.example.componet;

import com.example.pojo.Bill;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.MessageHeaders;

public class BillSubmitMessageHandler implements GenericHandler<Bill> {
    @Override
    public Object handle(Bill bill, MessageHeaders messageHeaders) {
        return null;
    }
}
