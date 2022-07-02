package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class inController {

    @RequestMapping("index")
    public String goIndex(){
        return "index";
    }


}
