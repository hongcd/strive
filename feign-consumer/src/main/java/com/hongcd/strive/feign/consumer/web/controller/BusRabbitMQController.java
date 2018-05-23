package com.hongcd.strive.feign.consumer.web.controller;

import com.hongcd.strive.common.utils.Response;
import com.hongcd.strive.feign.consumer.amqp.StriveSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/busRabbit")
public class BusRabbitMQController extends BaseController {
    @Autowired
    private StriveSender striveSender;

    @GetMapping("/sendMsg")
    public Response sendMsg(String msg) {
        striveSender.send(msg);
        return renderSuccess();
    }
}