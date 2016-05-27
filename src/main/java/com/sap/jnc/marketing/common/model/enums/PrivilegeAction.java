package com.sap.jnc.marketing.common.model.enums;

import com.sap.jnc.marketing.common.model.ListableEnum;

/**
 * Flag which action would be privileged within our system
 *
 * @author I071053 Diouf Du
 */
public enum PrivilegeAction implements ListableEnum {

	// Create
	CREATE("Create"),
	// Update
	UPDATE("Update"),
	// Delete
	DELETE("Delete"),
	// Read
	READ("READ"),
	// Archive
	ARCHIVE("Archive"),
	// Execute
	EXECUTE("Execute");

	private String description;

	private PrivilegeAction(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

}
