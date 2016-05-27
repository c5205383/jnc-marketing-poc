package com.sap.jnc.marketing.persistence.exceptions.marshalling;

import com.sap.jnc.marketing.persistence.exceptions.CommonPersistenceException;

/**
 * Thrown when unmarshalling an attribute failed.
 * 
 * @author Janosch Fock
 */
public class UnmarshallingFailedException extends CommonPersistenceException {

	private static final long serialVersionUID = 6762549275419126944L;

	/**
	 * @param e
	 *            the cause of this exception
	 */
	public UnmarshallingFailedException(final Exception e) {
		super(e);
	}

}
