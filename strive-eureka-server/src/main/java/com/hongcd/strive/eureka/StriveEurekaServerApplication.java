package com.hongcd.strive.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class StriveEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StriveEurekaServerApplication.class, args);
    }
}