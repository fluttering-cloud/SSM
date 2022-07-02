package com.example.threadSafe.Component;

import com.example.threadSafe.beans.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Components {
    @Bean
    public UserService userService(){
        return new UserService();
    }
}
