package com.wang.controller;

import com.wang.pojo.Books;
import com.wang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    public void setBookService(BookService bookService){
        this.bookService = bookService;
    }

    @RequestMapping("/selectBook")
    public String selectBookById( Model model){

        Books book = bookService.selectBooksById(1);
        model.addAttribute("book",book);
        return "book";
    }

    @RequestMapping("addBook")
    public String addBook(){
        return "addBook";
    }

    @RequestMapping("addBookC")
    public String addBookController(Books books){

        bookService.addbook(books);
        return "book";
    }

    @RequestMapping("updateBook")
    public String updateBook(){
        return "updatebook";
    }

    @RequestMapping("updataBooks")
    public String updataBooks(Books books){
        bookService.updataBookById(books);
        return "book";
    }

    @RequestMapping("download")
    public String download(){
        return "download";
    }


}
