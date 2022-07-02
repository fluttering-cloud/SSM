package com.wang.config;



import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //3.ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);

        //添加shiro的内置过滤器
        /*
         anon：无需认证就可以访问
         authc:必须认证才能访问
         user:必须拥有 记住我 功能才能访问
         perms:必须拥有对某个资源的访问权限才能访问
         role:必须拥有相应的角色才能范围
         */
        Map<String,String> definitionMap = new LinkedHashMap<>();
        definitionMap.put("/add","authc");
        definitionMap.put("/update","authc");

        bean.setFilterChainDefinitionMap(definitionMap);

        //设置登入页
        bean.setLoginUrl("/toLogin");
        return bean;

    }

    //2.defaultWebSecurityManager
    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);

        return securityManager;
    }

    //1.创建realm对象，需要自定义
    @Bean("userRealm")
    public UserRealm UserRealm(){
        return new UserRealm();
    }
}
