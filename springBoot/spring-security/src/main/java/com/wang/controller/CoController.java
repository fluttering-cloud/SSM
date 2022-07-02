package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CoController {

     @RequestMapping("/vip1")
     public String go1(){

        return "vip1";
     }

    @RequestMapping("/vip2")
    public String go2(){

        return "vip2";
    }

    @RequestMapping("/vip3")
    public String go3(){

        return "vip3";
    }

   @RequestMapping("/loginS")
    public String login(){
         return "login";
    }


}
