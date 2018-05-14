package com.hongcd.strive.common.constant;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {
    @Value("${server.port}")
    @Getter private Integer serverPort;
    @Value("${spring.application.name}")
    @Getter private String serverName;
}