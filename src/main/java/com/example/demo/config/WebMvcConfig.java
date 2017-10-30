package com.example.demo.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.common.collect.ImmutableList;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.extendMessageConverters(converters);
		converters.add(new ByteArrayHttpMessageConverter());
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		jsonConverter.setSupportedMediaTypes(ImmutableList.of(MediaType.TEXT_HTML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN));
		jsonConverter.setDefaultCharset(Charset.forName("UTF-8"));
		converters.add(jsonConverter);

	}

}
