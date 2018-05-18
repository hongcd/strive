package com.hongcd.strive.provider.web.controller;

import com.hongcd.strive.common.utils.Response;
import com.hongcd.strive.entity.book.Book;
import com.hongcd.strive.provider.api.ProviderBookService;
import com.hongcd.strive.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController extends BaseController implements ProviderBookService {
    @Autowired
    private BookService bookService;

    @Override
    public Response<List<Book>> findAll() {
        return renderSuccess(bookService.listAll());
    }

    @PostMapping("/listByIds")
    public Response<List<Book>> listByIds(@RequestBody List<String> ids) {
        return renderSuccess(bookService.listByIds(ids));
    }

    /**
     * 获取图书
     * @param id
     * @return
     */
    @Override
    public Response<Book> getById(@PathVariable String id) {
        return renderSuccess(bookService.getById(id));
    }
}