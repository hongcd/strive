package com.hongcd.strive.common.constant;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 配置类，存放系统基本配置
 * @author HongD
 */
@Component
public class Config {
    @Value("${server.port}")
    @Getter private Integer serverPort;
    @Value("${spring.application.name}")
    @Getter private String serverName;
}