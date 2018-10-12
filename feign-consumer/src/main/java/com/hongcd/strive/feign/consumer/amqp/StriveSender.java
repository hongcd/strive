package com.hongcd.strive.feign.consumer.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author HongD
 */
@Slf4j
@Component
public class StriveSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String msg) {
        log.info("Strive Sender msg: " + msg);
        amqpTemplate.convertAndSend("strive", msg);
    }
}