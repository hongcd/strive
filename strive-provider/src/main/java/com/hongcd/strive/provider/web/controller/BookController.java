package com.hongcd.strive.provider.web.controller;

import com.hongcd.strive.entity.book.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController extends BaseController {
    /**
     * 获取图书
     * @param id
     * @return
     */
    @GetMapping("/getBook/{id}")
    public Book getBook(@PathVariable String id) {
        return null;
    }
}