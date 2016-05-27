package com.sap.jnc.marketing.persistence.exceptions;

import com.sap.jnc.marketing.common.exceptions.CommonApplicationException;

public class CommonPersistenceException extends CommonApplicationException {
	private static final long serialVersionUID = 1L;

	public CommonPersistenceException(String errorMessage) {
		super(errorMessage);
	}

	public CommonPersistenceException(String errorMessage, Exception ex) {
		super(errorMessage, ex);
	}

	/**
	 * @param e
	 *            the cause of this exception
	 */
	public CommonPersistenceException(final Exception e) {
		super(e);
	}
}
