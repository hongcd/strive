package com.hongcd.strive.provider.web.controller;

import com.hongcd.strive.common.utils.Response;
import com.hongcd.strive.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController extends BaseController {
    @Autowired
    private BookService bookService;

    @GetMapping("/findAll")
    public Response finAll() {
        return renderSuccess(bookService.listAll());
    }

    /**
     * 获取图书
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Response getBook(@PathVariable String id) {
        return renderSuccess(bookService.getById(id));
    }
}