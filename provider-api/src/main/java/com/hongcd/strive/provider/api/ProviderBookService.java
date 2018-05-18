package com.hongcd.strive.provider.api;

import com.hongcd.strive.common.utils.Response;
import com.hongcd.strive.entity.book.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/book")
public interface ProviderBookService {
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    Response<List<Book>> findAll();

    @RequestMapping(value = "/listByIds", method = RequestMethod.POST)
    Response<List<Book>> listByIds(List<String> ids);

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    Response<Book> getById(@PathVariable("id") String id);
}