package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.sql.Array;
import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //配置Docket实例，这是swagger的核心实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                /*
                .groupName("xxx")
                用于协同开发，即有多人开发时，每个人都有一个自己的Docket对象，
                在swagger内就用设置的组名来查看相应组的api信息了
                 */
                .apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .build();
    }

      /*
         1.select用于选择接口，只有被选择的接口才会在文档显示
         2.RequestHandlerSelectors：这个对象用于寻找借口，然后将寻找结果返回给select
         3.build:使用工厂模式来生成这个对象
       */


    //配置swagger信息apiInfo
    private ApiInfo apiInfo(){

        //文档的作者、链接、邮箱等信息
        Contact contact = new Contact("","","");

        //生成文档信息对象，里面包含文档的标题、版本、作者等基本信息基本信息
        return new ApiInfo(
         "狂神的api文档",
                "即使再小的帆也能远航",
                "v1.2",
                 "",
                 contact,
                "Apache 2.0",
               "",
               new ArrayList()
        );
    }
}
