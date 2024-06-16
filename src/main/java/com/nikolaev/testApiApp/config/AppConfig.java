package com.nikolaev.testApiApp.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "app")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppConfig {
	List<String> currencies;
	String token;
}
