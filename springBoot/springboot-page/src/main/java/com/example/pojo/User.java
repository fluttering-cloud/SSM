package com.example.pojo;

import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name="t_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;
}
