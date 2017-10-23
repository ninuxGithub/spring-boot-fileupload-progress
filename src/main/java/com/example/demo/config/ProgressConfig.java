package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.component.CustomMultipartResolver;

@Configuration
public class ProgressConfig {

	@Bean
	public CustomMultipartResolver multipartResolver() {
		CustomMultipartResolver customMultipartResolver = new CustomMultipartResolver();
		customMultipartResolver.setDefaultEncoding("UTF-8");
		customMultipartResolver.setMaxUploadSize(10000000000L);
		return customMultipartResolver;
	}

}
