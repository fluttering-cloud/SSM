package com.wang.consumer_service;

import com.wang.consumer_service.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerServiceApplicationTests {

    @Autowired
    UserService wangUserService;
    @Test
    void contextLoads() {

        wangUserService.buyTicket();
    }

}
