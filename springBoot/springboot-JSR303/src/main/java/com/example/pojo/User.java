package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {


    @NotNull
    @Email(message="邮箱格式错误")
    private String userName;
    @NotNull
    @Size(min = 5,message="输入的密码必须大于五位")
    private String password;


}
