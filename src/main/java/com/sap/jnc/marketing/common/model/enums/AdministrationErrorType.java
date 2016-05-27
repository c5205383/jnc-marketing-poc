package com.sap.jnc.marketing.common.model.enums;

/**
 * Enumeration of error types that can occur in the Administration UI.
 * 
 * @author Michael Braun
 */
public enum AdministrationErrorType {

	/** Undefined */
	OTHER,
	/** A runtime error occurred, mostly an uncaught exception. */
	RUNTIME,
	/** A security error such as authorization issues */
	SECURITY,
	/** A mere warning, nothing that stopped the ad serving process. */
	WARNING,
	// TODO javadoc
	USER_INCIDENT,
	/** The client's input was malformed and could not be parsed correctly. */
	INPUT

}
