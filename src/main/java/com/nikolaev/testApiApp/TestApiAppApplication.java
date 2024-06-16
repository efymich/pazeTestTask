package com.nikolaev.testApiApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties
public class TestApiAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestApiAppApplication.class, args);
	}
}
