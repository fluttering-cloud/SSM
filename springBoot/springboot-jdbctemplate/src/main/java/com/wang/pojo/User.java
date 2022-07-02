package com.wang.pojo;

public class User {

    private String name;
    private String password;
    private int age;

    public User(String name, String password) {
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int  getAge(){
        return age;
    }

}
