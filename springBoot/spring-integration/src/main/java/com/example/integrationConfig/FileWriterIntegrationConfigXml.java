package com.example.integrationConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
@ImportResource("classpath:filewriter-config.xml")
public class FileWriterIntegrationConfigXml {

    //声明转换器
    @Bean
    @Transformer(inputChannel = "text2InChannel",outputChannel = "fileWriter2Channel")
    public GenericTransformer<String,String> upperCaseTransformer(){
        return text -> text.toUpperCase();  //lambda 表达式
    }

    //声明文件写入器
    @Bean
    @ServiceActivator(inputChannel = "fileWriter2Channel")
    public FileWritingMessageHandler fileWriter(){
        FileWritingMessageHandler handler
                  = new FileWritingMessageHandler(new File("/file"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return handler;
    }

    @Bean
    public MessageChannel fileWriter2Channel(){
        return new DirectChannel();
    }

}

/*
   注意：
    *  1，配置转换器需要使用  @Transformer 来声明 输入通道 和 输出通道
    * 2.若我们没有显示的配置 输入通道和输出通道 的类，则集成流在运行时会自动的为我们配置它们的实体类，
        当然我们也可以自己显示的配置，这样我们可以根据实际的业务需求来配置通道
    *  3.@ServiceActivator(inputChannel = "fileWriter2Channel") 表示这是一个消费消息的类，
        这个类会从 fileWriter2Channel 内获取消息，并且将其传递给 FileWritingMessageHandler
        (消息处理器)，然后消息处理器将消息写入设置好的文件内。
     * 4.setExpectReply(false) 关闭服务激活器

 */