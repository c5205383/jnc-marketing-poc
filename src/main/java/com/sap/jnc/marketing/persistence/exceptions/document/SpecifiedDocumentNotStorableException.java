package com.sap.jnc.marketing.persistence.exceptions.document;

import com.sap.jnc.marketing.persistence.exceptions.CommonPersistenceException;

public class SpecifiedDocumentNotStorableException extends CommonPersistenceException {

	/**
	 * Generated Serial Version UID
	 */
	private static final long serialVersionUID = 8424549524383908602L;

	protected static final String DEFAULT_DESCRIPTION = "Can't store specified document due to some internal system error.";

	public SpecifiedDocumentNotStorableException() {
		super(String.format(DEFAULT_DESCRIPTION));
	}

	public SpecifiedDocumentNotStorableException(Exception ex) {
		super(String.format(DEFAULT_DESCRIPTION), ex);
	}
}
