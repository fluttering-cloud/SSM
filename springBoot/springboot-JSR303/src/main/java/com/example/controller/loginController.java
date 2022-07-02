package com.example.controller;

import com.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class loginController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("goLogin")
    public String goLogin(Model model){
        model.addAttribute("user",new User());
        return "login";
    }

    @RequestMapping("login")
    public String login(@Valid User user, Errors error, Model model){
        if (error.hasErrors()) {
            return "login";
        } else {
            return "index";
        }

    }
}
