package com.hongcd.strive.provider.web.controller;

import com.hongcd.strive.entity.book.Book;
import com.hongcd.strive.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController extends BaseController {
    @Autowired
    private BookService bookService;

    @GetMapping("/findAll")
    public List<Book> finAll() {
        return bookService.listAll();
    }

    /**
     * 获取图书
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Book getBook(@PathVariable String id) {
        return bookService.getById(id);
    }
}