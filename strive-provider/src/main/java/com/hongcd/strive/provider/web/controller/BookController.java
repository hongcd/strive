package com.hongcd.strive.provider.web.controller;

import com.hongcd.strive.common.utils.Response;
import com.hongcd.strive.entity.book.Book;
import com.hongcd.strive.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController extends BaseController {
    @Autowired
    private BookService bookService;

    @GetMapping("/findAll")
    public Response finAll() {
        return renderSuccess(bookService.listAll());
    }

    @GetMapping("/listByIds")
    public List<Book> listByIds(@RequestBody List<String> ids) {
        return bookService.listByIds(ids);
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