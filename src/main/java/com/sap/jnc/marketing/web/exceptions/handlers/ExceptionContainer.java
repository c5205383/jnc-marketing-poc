package com.sap.jnc.marketing.web.exceptions.handlers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionContainer<TBody> {

	@JsonProperty("error")
	protected TBody body;

	public ExceptionContainer(TBody body) {
		this.body = body;
	}

	public TBody getBody() {
		return this.body;
	}
}
