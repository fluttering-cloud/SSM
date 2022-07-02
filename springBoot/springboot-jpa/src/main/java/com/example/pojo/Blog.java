package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //使用 jpa 的话，就要使用此注解，表示这是一个符合 jpa 的实体类
@Table(name = "t_blog") //使用此注解，表示这个实体类会自动和数据库内的表对应
public class Blog {
    @Id //声明 id 为主键
    @GeneratedValue  //表示自动生成id
    private Long id;

    private String title;  //博客标题
    private String content; //博客内容
    private String firstPicture; //博客首图
    private String flag;
    private Integer views; //博客浏览量
    private boolean appreciation; //是否开启赞赏
    private boolean shareStatement; //是否展示评论
    private boolean commentTabled; //是否开启评论
    private boolean publish; //是否显示出版信息
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime; //博客创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime; //博客修改日期

    @ManyToOne
    private Type type;

     /*
        cascade 表示级联关系，{CascadeType.PERSIST} 表示 当 tags 变动后，数据库的 blog表 内的 tags属性 会同时被更新
     */
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();



}
