package com.wang.dao;

import com.wang.pojo.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


public interface BooksMapper {

    //查找书籍
    public Books selectBooksById(@Param("bookID") int bookId);
    //增加书籍
    public void addBooks(Books books);

    //修改书籍
    public void updataBookById(Books books);
    //删除书籍

}
