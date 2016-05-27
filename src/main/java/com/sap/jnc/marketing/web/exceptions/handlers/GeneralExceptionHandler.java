package com.sap.jnc.marketing.web.exceptions.handlers;

import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpServletResponse;

public abstract class GeneralExceptionHandler<TException extends Exception, TBody> implements ExceptionHandler<TException, TBody> {

	@Override
	public int getStatusCode() {
		return HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<TException> getExceptionType() {
		return (Class<TException>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments())[0];
	}
}
