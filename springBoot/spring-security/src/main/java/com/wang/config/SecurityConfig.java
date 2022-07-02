package com.wang.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //授权方法
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //授予不同的页面访问级别
        http.authorizeRequests()
                //.antMatchers("/login").hasRole("")
                  .antMatchers("/vip1").hasRole("vip1")  //必须有vip1的权限才能访问
                  .antMatchers("/vip3").access("hasRole('vip3')") //必须有vip1的权限才能访问
                  .antMatchers("/","/**").permitAll()
               .and()
                .formLogin()
                   .loginPage("/loginS")
                   .defaultSuccessUrl("/index")
                   .usernameParameter("usernames") //与login页面输入框的名字必须相同，用于参数映射
                   .passwordParameter("password") //与login页面输入框的名字必须相同，用于参数映射
               .and()
                 .rememberMe()
              .and()
                .logout()
                .logoutSuccessUrl("/"); //在任何请求下的 /logout请求都会被拦截
    }


    //DataSource dataSource;
    //认证方法
    //密码通常要加密
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.inMemoryAuthentication()
                  .passwordEncoder(new BCryptPasswordEncoder())
                  .withUser("wang").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip3")
                  .and()
                  .withUser("xiaoWang").password(new BCryptPasswordEncoder().encode("1111")).roles("vip1");


        /*
        String sql="xxx";
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .authoritiesByUsernameQuery(sql);
       */
    }



}
