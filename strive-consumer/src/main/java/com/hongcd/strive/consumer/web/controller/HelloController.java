package com.hongcd.strive.consumer.web.controller;

import com.hongcd.strive.common.utils.Response;
import com.hongcd.strive.consumer.collapser.book.BookListByIdsCollapseCommand;
import com.hongcd.strive.consumer.service.BookServiceExtension;
import com.hongcd.strive.entity.book.Book;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/hello")
public class HelloController extends BaseController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private BookServiceExtension bookServiceExtension;

    @GetMapping("/books")
    public Response helloBooks() throws ExecutionException, InterruptedException {
        return bookServiceExtension.findAll();
    }

    @GetMapping("/book/get/{id}")
    public Response getById(@PathVariable String id) throws ExecutionException, InterruptedException {
        return renderSuccess(bookServiceExtension.getById(id).get());
    }

    @PostMapping("/book/listByIds")
    public Response<List<Book>> listByIds(@RequestBody List<String> ids) throws ExecutionException, InterruptedException {
        List<Book> result;
        try (HystrixRequestContext context = HystrixRequestContext.initializeContext()) {
            result = new ArrayList<>();
            for (int i = 0; i < ids.size() - 1; i++) {
                result.add(new BookListByIdsCollapseCommand(bookServiceExtension, ids.get(i)).queue().get());
            }
            Thread.sleep(3000);
            if (ids.size() > 1) {
                result.add(new BookListByIdsCollapseCommand(bookServiceExtension, ids.get(ids.size() - 1)).queue().get());
            }
        }
        return renderSuccess(result);
    }
}