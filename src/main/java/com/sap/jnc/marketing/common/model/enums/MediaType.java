package com.sap.jnc.marketing.common.model.enums;

import com.sap.jnc.marketing.common.model.ListableEnum;

public enum MediaType implements ListableEnum {

	IMAGE(1), RICH_MEDIA(2);

	private int flag;

	private MediaType(int flag) {
		this.flag = flag;
	}

	public int getFlag() {
		return this.flag;
	}
}