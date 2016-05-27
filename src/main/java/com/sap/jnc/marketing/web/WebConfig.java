package com.sap.jnc.marketing.web;

import java.util.List;

import javax.naming.InitialContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sap.jnc.marketing.web.interceptors.CustomizedHandlerInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	private static final int MAX_UPLOAD_SIZE = 4 * 1024 * 1024;

	@Autowired
	protected InitialContext initialContext;

	@Autowired(required = false)
	protected List<CustomizedHandlerInterceptor> customizedHandlerInterceptors;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		if (this.customizedHandlerInterceptors != null) {
			for (CustomizedHandlerInterceptor customizedHandlerInterceptor : this.customizedHandlerInterceptors) {
				registry.addInterceptor(customizedHandlerInterceptor);
			}
		}
	}

	@Override
	public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {
		final Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS).featuresToEnable(Feature.WRITE_BIGDECIMAL_AS_PLAIN);
		converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
	}
}
