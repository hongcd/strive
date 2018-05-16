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
import java.util.concurrent.Future;

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
        List<Book> result = new ArrayList<>();
        List<Future<Book>> futures = new ArrayList<>();
        try (HystrixRequestContext context = HystrixRequestContext.initializeContext();) {
            for (String id : ids) {
                futures.add(new BookListByIdsCollapseCommand(bookServiceExtension, id).queue());
            }
            for (Future<Book> future : futures) {
                result.add(future.get());
            }
        }
        return renderSuccess(result);
    }

    @PostMapping("/collapseListByIds")
    public Response collapseListByIds(@RequestBody List<String> ids) throws ExecutionException, InterruptedException {
        List<Book> result = new ArrayList<>();
        List<Future<Book>> futures = new ArrayList<>();
        try (HystrixRequestContext context = HystrixRequestContext.initializeContext()) {
            for (String id : ids) {
                futures.add(bookServiceExtension.annotationCollapseGet(id));
            }
            for (Future<Book> future : futures) {
                result.add(future.get());
            }
        }
        return renderSuccess(result);
    }
}