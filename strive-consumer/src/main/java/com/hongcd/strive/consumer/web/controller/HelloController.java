package com.hongcd.strive.consumer.web.controller;

import com.hongcd.strive.common.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello")
public class HelloController extends BaseController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/books")
    public Response helloBooks() {
        return render(restTemplate.getForObject("http://provider/book/findAll", Response.class));
    }

    @GetMapping("/{id}")
    public Response getById(@PathVariable String id) {
        return render(restTemplate.getForObject("http://PROVIDER/book/{1}", Response.class, id));
    }
}