package com.sap.jnc.marketing.web.exceptions.handlers;

import com.sap.jnc.marketing.common.exceptions.CommonApplicationException;

public abstract class GeneralCommonExceptionHandler<TException extends CommonApplicationException> extends GeneralExceptionHandler<TException, String> {

	@Override
	public String getBody(TException ex) {
		return ex.getErrorMessage();
	}
}
