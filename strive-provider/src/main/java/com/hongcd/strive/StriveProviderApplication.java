package com.hongcd.strive;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author HongD
 */
@SpringCloudApplication
public class StriveProviderApplication {
    @Getter
    @Value("${server.port}")
    private Integer serverPort;

    public static void main(String[] args) {
        SpringApplication.run(StriveProviderApplication.class, args);
    }
}
