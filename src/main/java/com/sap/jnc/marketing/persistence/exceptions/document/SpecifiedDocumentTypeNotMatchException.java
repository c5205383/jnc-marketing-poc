package com.sap.jnc.marketing.persistence.exceptions.document;

import com.sap.jnc.marketing.persistence.exceptions.CommonPersistenceException;

public class SpecifiedDocumentTypeNotMatchException extends CommonPersistenceException {

	/**
	 * Generated Serial Version UID
	 */
	private static final long serialVersionUID = 8424549524383908602L;

	protected static final String DEFAULT_DESCRIPTION = "The specified found by %s isn't valid document.";

	protected static final String DEFAULT_CRITERIA = "id";

	public SpecifiedDocumentTypeNotMatchException() {
		super(String.format(DEFAULT_DESCRIPTION, DEFAULT_CRITERIA));
	}

	public SpecifiedDocumentTypeNotMatchException(String missingCriteria) {
		super(String.format(DEFAULT_DESCRIPTION, missingCriteria));
	}

	public SpecifiedDocumentTypeNotMatchException(Exception ex) {
		super(String.format(DEFAULT_DESCRIPTION, DEFAULT_CRITERIA), ex);
	}

	public SpecifiedDocumentTypeNotMatchException(String missingCriteria, Exception ex) {
		super(String.format(DEFAULT_DESCRIPTION, missingCriteria), ex);
	}
}
