package com.example.service;

import com.example.dao.UserRepository;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImp implements UserService{

    /*
       在变量上使用 @Autowired 和在 set 方法使用 @Autowired 的区别：
       1.依赖注入的方式：变量注入、构造器注入、set 方法注入
       2.三总方法的优缺点：
           变量注入 ： 优点：代码简洁明了。 缺点 ：当注入属性为空时会报 空指针异常的错误
           set注入 ： 优点：这是一种选择注入，可有可无，即使没有注入这个依赖，那么也不会影响整个类的运行，即可以为空
           构造器注入：使用构造器方式时已经显式注明必须强制注入。通过强制指明依赖注入来保证这个类的运行
       3.推荐使用：set 注入
         原因 ：
              依赖注入的核心思想之一就是被容器管理的类不应该依赖被容器管理的依赖，换成白话来说就是如果这个类使用了依赖注入的类，
         那么这个类摆脱了这几个依赖必须也能正常运行。然而使用变量注入的方式是不能保证这点的。既然使用了依赖注入方式，那么
         就表明这个类不再对这些依赖负责，这些都由容器管理，那么如何清楚的知道这个类需要哪些依赖呢？它就要使用set方法方式
         注入或者构造器注入。

     */
    private UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByNameAndPassword(String username, String password) {
        userRepository.findUserByUserNameAndPassword(username,password);
        return null;
    }


}
