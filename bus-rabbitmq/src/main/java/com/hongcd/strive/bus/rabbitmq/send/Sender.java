package com.hongcd.strive.bus.rabbitmq.send;

import lombok.extern.log4j.Log4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMsg(String msg) {
        log.info("Sender msg: " + msg);
        amqpTemplate.convertAndSend("strive", msg);
    }
}