package com.wang.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/index")
    public String goIndex(){
        return "index";
    }

    @RequestMapping("/add")
    public String add(){
        return "add";
    }

    @RequestMapping("/update")
    public String update(){
        return "update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("login")
    public String login(String userName, String password, Model model){
        //获取当前对象
        Subject subject = SecurityUtils.getSubject();
        //将登入信息封装成令牌
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        //验证令牌
        try {
            subject.login(token);
            return "index";
        }catch (UnknownAccountException e){//用户名错误
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){//密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
}
