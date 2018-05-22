package com.hongcd.strive.feign.consumer.web.controller;

import com.hongcd.strive.common.utils.Response;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/busRabbit")
public class BusRabbitMQController extends BaseController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("/sendMsg")
    public Response sendMsg(String msg) {
        amqpTemplate.convertAndSend("strive", msg);
        return renderSuccess();
    }
}