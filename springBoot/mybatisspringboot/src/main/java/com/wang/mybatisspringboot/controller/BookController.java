package com.wang.mybatisspringboot.controller;

import com.wang.mybatisspringboot.mapper.BooksMapper;
import com.wang.mybatisspringboot.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    BooksMapper booksMapper;

    @RequestMapping("/selectBooks")
     public String selectBook(){

         Books books = booksMapper.selectBookById(1);

         return books.toString();
     }

}
