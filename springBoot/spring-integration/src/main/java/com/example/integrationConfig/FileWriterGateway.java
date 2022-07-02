package com.example.integrationConfig;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

import java.util.logging.FileHandler;

/*
       @MessagingGateway 声明这是 spring integration 的网关接口,在运行时
    spring integration 会为被此标签标记的接口生成实现类和方法.与 jpa
    根据方法签名制动生成相应的方法 类似.
       defaultRequestChannel 用于设置消息要发送到哪个消息通道,如此例,当执行
    writeToFile 时,消息会发送到名为 textInChannel 的通道内
        @Header(FileHeaders.FILENAME) 表示传递给 filename 的值应该包含在
   消息头中,而不是放在消息载荷内.
 */
@MessagingGateway(defaultRequestChannel = "textInChannel")
public interface FileWriterGateway {

    void writeToFile(
            @Header(FileHeaders.FILENAME) String filename,
            String data
    );

}
