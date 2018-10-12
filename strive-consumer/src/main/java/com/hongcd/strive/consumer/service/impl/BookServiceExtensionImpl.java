package com.hongcd.strive.consumer.service.impl;

import com.hongcd.strive.common.utils.Response;
import com.hongcd.strive.consumer.command.book.BookFindAllCommand;
import com.hongcd.strive.consumer.service.BookServiceExtension;
import com.hongcd.strive.entity.book.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author HongD
 */
@Slf4j
@Service
public class BookServiceExtensionImpl implements BookServiceExtension {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Response findAll() throws ExecutionException, InterruptedException {
        BookFindAllCommand bookFindAllCommand = new BookFindAllCommand(restTemplate);
        return bookFindAllCommand.queue().get();
    }

    @Override
    @HystrixCommand
    public Future<Book> getById(String id) {
        return new AsyncResult<Book>() {
            @Override
            public Book invoke() {
                return restTemplate.getForObject("http://PROVIDER/book/{1}", Book.class, id);
            }
        };
    }

    @Override
    public List<Book> listByIds(Collection<String> ids) {
        log.info(String.format("listByIds thread: %s", Thread.currentThread().getName()));
        return Arrays.asList(restTemplate.postForObject("http://PROVIDER/book/listByIds", ids, Book[].class));
    }

    @Override
    @HystrixCollapser(collapserKey = "listByIdsCollapse", batchMethod = "collapseListByIds", collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds", value = "100")})
    public Future<Book> annotationCollapseGet(String id) {
        return null;
    }

    @HystrixCommand
    public List<Book> collapseListByIds(List<String> ids) {
        return listByIds(ids);
    }


    public Response findAllError() {
        try {
            return restTemplate.getForObject("http://PROVIDER/book/findAll", Response.class);
        } catch (RestClientException e) {
            return new Response(Response.FAIL, e.getMessage(), null);
        }
    }
}