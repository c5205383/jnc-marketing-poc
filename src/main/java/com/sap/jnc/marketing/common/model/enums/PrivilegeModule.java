package com.sap.jnc.marketing.common.model.enums;

import com.sap.jnc.marketing.common.model.ListableEnum;

/**
 * Flag which module would be privileged within our system
 *
 * @author I071053 Diouf Du
 */
public enum PrivilegeModule implements ListableEnum {

	// Business
	CMP("Campaign"), INV("Inventory"),
	// Account
	ACC_ADV("Account Advertiser"), ACC_PUB("Publisher Account"),
	// User
	ACC_ADV_USER("Advertiser Account User"), ACC_PUB_USER("Publisher Account User"),
	// Admin
	SAP_BSN_ADM("SAP Business Administration User"), SAP_SYS_ADM("SAP System Administration User"),
	// Report
	REPORT("Report");

	private String description;

	private PrivilegeModule(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

}
