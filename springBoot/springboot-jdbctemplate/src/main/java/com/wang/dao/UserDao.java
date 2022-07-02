package com.wang.dao;

import com.wang.pojo.User;

import java.util.List;

public interface UserDao {

    //查找所有人
    public List<User> getAllUser();


    //通过姓名查找
    public User getUserByName(String name);

    //添加用户
    public int addUser(User user);

    //修改用户信息
    public int updateUserPassword(String name,String password);

}
