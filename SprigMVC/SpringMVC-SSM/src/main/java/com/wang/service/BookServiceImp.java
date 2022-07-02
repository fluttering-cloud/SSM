package com.wang.service;

import com.wang.dao.BooksMapper;
import com.wang.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements BookService{

    @Autowired
    private BooksMapper booksMapper;

    @Override
    public Books selectBooksById(int bookId) {
        return booksMapper.selectBooksById(bookId);
    }

    @Override
    public void addbook(Books books) {
        System.out.println("添加书籍=》"+books);
        booksMapper.addBooks(books);
    }

    @Override
    public void updataBookById(Books books) {
        System.out.println("修改书籍=》"+books);
        booksMapper.updataBookById(books);
    }
}
