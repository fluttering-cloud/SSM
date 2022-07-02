package com.example.threadSafe.beans;

import org.springframework.stereotype.Component;


public class UserService {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void welcome(String name) {

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("welcome:"+name);
    }


}
