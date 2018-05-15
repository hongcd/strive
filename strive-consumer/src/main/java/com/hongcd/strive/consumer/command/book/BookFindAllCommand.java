package com.hongcd.strive.consumer.command.book;

import com.hongcd.strive.common.utils.Response;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lombok.extern.log4j.Log4j;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Log4j
public class BookFindAllCommand extends HystrixCommand<Response> {
    private RestTemplate restTemplate;

    public BookFindAllCommand(RestTemplate restTemplate) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("book")));
        this.restTemplate = restTemplate;
    }

    @Override
    protected Response getFallback() {
        log.warn("Invoke http://PROVIDER/book/findAll fail! retry!");
        try {
            return restTemplate.getForObject("http://PROVIDER/book/findAll", Response.class);
        } catch (RestClientException e) {
            log.error("Invoke http://PROVIDER/book/findAll fail! msg: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    protected Response run() {
        log.info("Invoke http://PROVIDER/book/findAll");
        return restTemplate.getForObject("http://PROVIDER/book/findAll", Response.class);
    }
}