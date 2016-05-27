package com.sap.jnc.marketing.common.model.enums;

/**
 * Flag the status of account
 * 
 * @author I071053
 */
public enum AdCreativeStatus {

	/*
	 * Constant
	 */

	ACTIVE(0, "Active"), DELETED(1, "Deleted");

	protected Integer id;

	protected String description;

	AdCreativeStatus(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return this.getDescription();
	}
}
