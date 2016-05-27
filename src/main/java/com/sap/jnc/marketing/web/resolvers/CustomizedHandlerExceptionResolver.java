package com.sap.jnc.marketing.web.resolvers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sap.jnc.marketing.web.exceptions.handlers.DefaultExceptionHandler;
import com.sap.jnc.marketing.web.exceptions.handlers.ExceptionContainer;
import com.sap.jnc.marketing.web.exceptions.handlers.ExceptionHandler;

@SuppressWarnings("rawtypes")
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Lazy(true)
public class CustomizedHandlerExceptionResolver extends DefaultHandlerExceptionResolver {

	private static final String DEFAULT_CONTENT_TYPE = "application/json";

	@Autowired
	protected DefaultExceptionHandler defaultExceptionHandler;

	@Autowired
	protected List<ExceptionHandler> exceptionHandlers;

	@Autowired
	protected ObjectMapper mapper;

	@SuppressWarnings("unchecked")
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		response.setHeader(HttpHeaders.CONTENT_TYPE, DEFAULT_CONTENT_TYPE);
		response.setStatus(this.getStatusCode(ex));
		try {
			this.mapper.writeValue(response.getWriter(), new ExceptionContainer(this.getExceptionHandler(ex).getBody(ex)));
		} catch (IOException ex0) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return new ModelAndView();
	}

	protected int getStatusCode(Exception ex) {
		return this.getExceptionHandler(ex).getStatusCode();
	}

	protected ExceptionHandler getExceptionHandler(Exception ex) {
		// Check for exception hierarchy type match
		Class<?> exceptionType = ex.getClass();
		while (exceptionType != null) {
			for (ExceptionHandler exceptionHandler : this.exceptionHandlers) {
				if (exceptionType.equals(exceptionHandler.getExceptionType())) {
					return exceptionHandler;
				}
			}
			exceptionType = exceptionType.getSuperclass();
		}
		// Check for expection hierarchy for exception itself
		for (ExceptionHandler exceptionHandler : this.exceptionHandlers) {
			if (exceptionHandler.getExceptionType().isInstance(ex)) {
				return exceptionHandler;
			}
		}
		// Check for one-level exception interfaces type match
		for (ExceptionHandler exceptionHandler : this.exceptionHandlers) {
			if (Arrays.asList(ex.getClass().getInterfaces()).contains(exceptionHandler.getExceptionType())) {
				return exceptionHandler;
			}
		}
		return this.defaultExceptionHandler;
	}
}
