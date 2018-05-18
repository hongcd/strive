package com.hongcd.strive.feign.consumer.client;

import com.hongcd.strive.common.utils.Response;
import com.hongcd.strive.entity.book.Book;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("ProviderSecond")
public interface ProviderSecondClient {
    @RequestMapping(value = "/book/findAll", method = RequestMethod.GET)
    Response<List<Book>> findAll();
}