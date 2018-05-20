package com.hongcd.strive.ac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class AuthorizationCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationCenterApplication.class, args);
    }
}