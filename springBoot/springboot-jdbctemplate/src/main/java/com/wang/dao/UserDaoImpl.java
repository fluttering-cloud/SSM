package com.wang.dao;

import com.wang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

   private JdbcTemplate template;

   @Autowired
   public void setTemplate(JdbcTemplate jdbcTemplate){
       this.template = template;
   }

    /*
        结果集映射，queryForObject() 会将查询到的结果根据这个映射
        关系生成一个User对象，由此可见，输入 JdbcTemplate 比传统
        的 jdbc 要简单许多，可以映射关系、sql语句都在这个类内实现，
        还是显得很混乱,即使这个映射关系可以用 lambda 简化
        this::mapRowToUser ：lambda
     */
    private User mapRowToUser(ResultSet resultSet, int i) throws SQLException {
        return new User(resultSet.getString("name"),resultSet.getString("password"));
    }

    //通过姓名查找
    @Override
    public User getUserByName(String name) {
        String sql = "select * from user where name=?";
        return template.queryForObject(sql,this::mapRowToUser, name);
    }

    //查找所有人
    @Override
    public List<User> getAllUser() {
        String sql = "select * from user";
       return template.query(sql,this::mapRowToUser);
    }

    //添加用户
    @Override
    public int addUser(User user) {
        String sql = "inset into user(name,password,age) values(?,?,?)";
       return template.update(sql,user.getName(),user.getPassword(),user.getAge());
    }

    //修改用户信息
    @Override
    public int updateUserPassword(String name, String password) {

        String sql = "update user set password = ? where name = ? ";

        return template.update(sql,name,password);
    }


}
