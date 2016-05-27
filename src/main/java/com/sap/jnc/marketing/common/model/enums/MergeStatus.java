package com.sap.jnc.marketing.common.model.enums;

/**
 * Flag the status on merging sub-entity into many relationship to the parent-entity
 *
 * @author I071053
 */
public enum MergeStatus {

	/*
	 * Constant
	 */

	NEW("New"), EXISTS("Existed"), DELETE("Delete");

	protected String description;

	MergeStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return this.getDescription();
	}
}
