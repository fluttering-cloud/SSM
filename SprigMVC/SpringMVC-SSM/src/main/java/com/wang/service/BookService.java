package com.wang.service;

import com.wang.pojo.Books;

public interface BookService {

    //查找书籍
    public Books selectBooksById(int bookId);

    //添加书籍
    public void addbook(Books books);

    //修改书籍信息
    public void updataBookById(Books books);
}
