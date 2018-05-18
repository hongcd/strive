package com.hongcd.strive.feign.consumer.web.controller;

import com.hongcd.strive.common.utils.Response;
import com.hongcd.strive.entity.book.Book;
import com.hongcd.strive.feign.consumer.client.ProviderBookClient;
import com.hongcd.strive.feign.consumer.client.ProviderClient;
import com.hongcd.strive.feign.consumer.client.ProviderSecondClient;
import com.hongcd.strive.provider.api.ProviderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feignBook")
public class FeignBookController extends BaseController {
    @Autowired
    private ProviderClient providerClient;
    @Autowired
    private ProviderSecondClient providerSecondClient;
    @Autowired
    private ProviderBookClient providerBookClient;

    @GetMapping("/provider/findAll")
    public Response providerFindAll() {
        return providerClient.findAll();
    }

    @PostMapping(value = "/provider/listByIds")
    public Response<List<Book>> providerListByIds(@RequestBody List<String> ids) {
        return providerClient.listByIds(ids);
    }

    @GetMapping("/provider/book/findAll")
    public Response<List<Book>> providerBookFindAll() {
        return providerBookClient.findAll();
    }

    @GetMapping("/providerSecond/findAll")
    public Response<List<Book>> providerSecondFindAll() {
        return providerSecondClient.findAll();
    }
}