package com.nikolaev.testApiApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TestApiAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApiAppApplication.class, args);
    }

}
