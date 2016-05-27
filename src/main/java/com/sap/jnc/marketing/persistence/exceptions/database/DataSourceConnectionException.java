package com.sap.jnc.marketing.persistence.exceptions.database;

import com.sap.jnc.marketing.persistence.exceptions.CommonPersistenceException;

public class DataSourceConnectionException extends CommonPersistenceException {

	/**
	 * Generated Serial Version UID
	 */
	private static final long serialVersionUID = 1502404259606162165L;

	protected static final String DEFAULT_DESCRIPTION = "Can't connect specific data source, please refer to inner exception.";

	public DataSourceConnectionException() {
		super(DEFAULT_DESCRIPTION);
	}

	public DataSourceConnectionException(Exception ex) {
		super(DEFAULT_DESCRIPTION, ex);
	}
}
