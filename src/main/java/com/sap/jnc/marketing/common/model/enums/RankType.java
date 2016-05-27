package com.sap.jnc.marketing.common.model.enums;

/**
 * @author I073799
 */
public enum RankType {

	TOP("Top"), BUTTOM("Buttom"), OVER("Over"), UNDER("Under");

	private String description;

	private RankType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	@Override
	public String toString() {
		return this.getDescription();
	}
}
