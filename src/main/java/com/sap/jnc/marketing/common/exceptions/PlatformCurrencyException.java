package com.sap.jnc.marketing.common.exceptions;

/**
 * This class use throughout platform currency exceptions
 *
 * @author Yogesh
 */
public class PlatformCurrencyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PlatformCurrencyException(final String errorMessage) {
		super(errorMessage);
	}
}