package com.example.provide_service.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service //dubbo的标签
@Component
public class TicketServiceImp implements TicketService{
    @Override
    public String getTicket() {
        return "广州-》北京";
    }
}
