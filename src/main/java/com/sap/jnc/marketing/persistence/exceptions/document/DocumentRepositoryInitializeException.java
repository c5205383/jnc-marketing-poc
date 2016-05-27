package com.sap.jnc.marketing.persistence.exceptions.document;

import com.sap.jnc.marketing.persistence.exceptions.CommonPersistenceException;

public class DocumentRepositoryInitializeException extends CommonPersistenceException {

	/**
	 * Generated Serial Version UID
	 */
	private static final long serialVersionUID = 7604019168054754812L;

	protected static final String DEFAULT_DESCRIPTION = "The document repository initial failed deal to some internal error.";

	public DocumentRepositoryInitializeException() {
		super(DEFAULT_DESCRIPTION);
	}

	public DocumentRepositoryInitializeException(Exception ex) {
		super(DEFAULT_DESCRIPTION, ex);
	}

	public DocumentRepositoryInitializeException(String errorMessage, Exception ex) {
		super(errorMessage, ex);
	}
}
