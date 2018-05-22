package com.hongcd.strive.bus.rabbitmq.consumer;

import lombok.extern.log4j.Log4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class HelloConsumer {
    @RabbitListener(queues = "strive", containerFactory = "rabbitListenerContainerFactory")
    public void process(String msg) {
        log.info("strive receive: " + msg);
    }
}