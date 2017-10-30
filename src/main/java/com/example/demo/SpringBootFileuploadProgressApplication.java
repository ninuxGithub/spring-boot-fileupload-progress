package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.example.demo.component.CustomMultipartResolver;

@SpringBootApplication
@Configuration  
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})  
public class SpringBootFileuploadProgressApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFileuploadProgressApplication.class, args);
	}

	@Bean(name = "multipartResolver")
	public MultipartResolver  multipartResolver() {
		CommonsMultipartResolver resolver = new CustomMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
        resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常  
        resolver.setMaxInMemorySize(40960);  
        resolver.setMaxUploadSize(5 * 1024 * 1024);//上传文件大小 5M 5*1024*1024  
		return resolver;
	}
}
