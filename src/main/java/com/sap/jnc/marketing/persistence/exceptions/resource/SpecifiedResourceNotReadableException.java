package com.sap.jnc.marketing.persistence.exceptions.resource;

import com.sap.jnc.marketing.persistence.exceptions.CommonPersistenceException;

public class SpecifiedResourceNotReadableException extends CommonPersistenceException {

	/**
	 * Generated Serial Version UID
	 */
	private static final long serialVersionUID = 616700821019893299L;

	protected static final String DEFAULT_DESCRIPTION_NO_NAME = "Can't read specified resource.";
	protected static final String DEFAULT_DESCRIPTION = "Can't read specified resource <%s>.";

	public SpecifiedResourceNotReadableException() {
		super(String.format(DEFAULT_DESCRIPTION_NO_NAME));
	}

	public SpecifiedResourceNotReadableException(String resourceName) {
		super(String.format(DEFAULT_DESCRIPTION, resourceName));
	}

	public SpecifiedResourceNotReadableException(String resourceName, Exception ex) {
		super(String.format(DEFAULT_DESCRIPTION, resourceName), ex);
	}
}
