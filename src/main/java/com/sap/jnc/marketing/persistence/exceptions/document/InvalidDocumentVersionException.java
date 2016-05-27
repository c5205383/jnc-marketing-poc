package com.sap.jnc.marketing.persistence.exceptions.document;

import com.sap.jnc.marketing.persistence.exceptions.CommonPersistenceException;

public class InvalidDocumentVersionException extends CommonPersistenceException {

	/**
	 * Generated Serial Version UID
	 */
	private static final long serialVersionUID = 8424549524383908602L;

	protected static final String DEFAULT_DESCRIPTION = "The document version is invalid.";

	public InvalidDocumentVersionException() {
		super(DEFAULT_DESCRIPTION);
	}

	public InvalidDocumentVersionException(Exception ex) {
		super(DEFAULT_DESCRIPTION, ex);
	}

}
