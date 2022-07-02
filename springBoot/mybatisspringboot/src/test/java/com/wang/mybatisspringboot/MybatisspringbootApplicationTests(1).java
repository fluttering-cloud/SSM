package com.wang.mybatisspringboot;

import com.wang.mybatisspringboot.mapper.BooksMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisspringbootApplicationTests {

    @Autowired
    BooksMapper booksMapper;

    @Test
    void contextLoads() {

        System.out.println(booksMapper.selectBookById(1));

    }

}
