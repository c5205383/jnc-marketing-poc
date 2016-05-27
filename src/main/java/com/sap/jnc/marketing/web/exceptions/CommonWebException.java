package com.sap.jnc.marketing.web.exceptions;

import com.sap.jnc.marketing.common.exceptions.CommonApplicationException;

public class CommonWebException extends CommonApplicationException {

	/**
	 * Generated Serial Version UID
	 */
	private static final long serialVersionUID = -49093352328654622L;

	public CommonWebException(String errorMessage) {
		super(errorMessage);
	}

	public CommonWebException(String errorMessage, Exception ex) {
		super(errorMessage, ex);
	}

	public CommonWebException(Exception ex) {
		super(ex);
	}
}
