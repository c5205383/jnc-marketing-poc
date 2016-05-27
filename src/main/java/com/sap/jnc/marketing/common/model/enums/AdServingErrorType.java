package com.sap.jnc.marketing.common.model.enums;

/**
 * Enumeration of error types that can occur during ad serving.
 * 
 * @author Janosch Fock
 */
public enum AdServingErrorType {

	/** Undefined */
	OTHER,
	/** An internal error occured, mostly an uncaught exception. */
	INTERNAL,
	/** The client's input was malformed and could not be parsed correctly. */
	INPUT,
	/** A mere warning, nothing that stopped the ad serving process. */
	WARNING

}
