package com.wang.consumer_service.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service //放入spring
public class UserService {

     //想要服务的话就要去注册中心拿
    @Reference // 在注册中心拿服务有两种方式， 一，pom坐标   二：定义路径相同的接口名，这里是第二种方式
    TicketService ticketService;

    public void buyTicket(){
        System.out.println("购票成功--》"+ticketService.getTicket());
    }
}
