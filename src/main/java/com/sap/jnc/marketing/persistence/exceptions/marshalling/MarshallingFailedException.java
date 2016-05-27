package com.sap.jnc.marketing.persistence.exceptions.marshalling;

import com.sap.jnc.marketing.persistence.exceptions.CommonPersistenceException;

/**
 * Thrown when marshalling an attribute failed.
 * 
 * @author Janosch Fock
 */
public class MarshallingFailedException extends CommonPersistenceException {

	private static final long serialVersionUID = -9125559630102304845L;

	/**
	 * @param e
	 *            the cause of this exception
	 */
	public MarshallingFailedException(final Exception e) {
		super(e);
	}

}
