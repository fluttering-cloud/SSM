package com.example.componet;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
   * 这是一个邮箱的配置类
   * 这个配置类内存有一个目的邮箱的基本消息
   * 将此类配置到集成流内，集成流可以通过 url 到这个邮箱获取邮件信息

 */

@Data
@Component
@ConfigurationProperties(prefix = "email")
public class EmailProperties {

    private String username;
    private String password;
    private String host;
    private String mailbox;
    private long pollRate = 3000;

    public String getUrl(){
        return String.format("//%s:%s@%s/%s",this.username,this.password,this.host,this.mailbox);
    }
}
