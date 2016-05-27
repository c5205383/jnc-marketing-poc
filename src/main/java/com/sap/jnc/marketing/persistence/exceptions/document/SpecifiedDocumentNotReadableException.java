package com.sap.jnc.marketing.persistence.exceptions.document;

import com.sap.jnc.marketing.persistence.exceptions.CommonPersistenceException;

public class SpecifiedDocumentNotReadableException extends CommonPersistenceException {

	/**
	 * Generated Serial Version UID
	 */
	private static final long serialVersionUID = 8424549524383908602L;

	protected static final String DEFAULT_DESCRIPTION = "Can't read specified document by %s.";

	protected static final String DEFAULT_CRITERIA = "id";

	public SpecifiedDocumentNotReadableException() {
		super(String.format(DEFAULT_DESCRIPTION, DEFAULT_CRITERIA));
	}

	public SpecifiedDocumentNotReadableException(String missingCriteria) {
		super(String.format(DEFAULT_DESCRIPTION, missingCriteria));
	}

	public SpecifiedDocumentNotReadableException(Exception ex) {
		super(String.format(DEFAULT_DESCRIPTION, DEFAULT_CRITERIA), ex);
	}

	public SpecifiedDocumentNotReadableException(String missingCriteria, Exception ex) {
		super(String.format(DEFAULT_DESCRIPTION, missingCriteria), ex);
	}
}
