package com.example.service;


import com.example.pojo.User;

public interface UserService {

    public User getUserByNameAndPassword(String username,String password);

}
