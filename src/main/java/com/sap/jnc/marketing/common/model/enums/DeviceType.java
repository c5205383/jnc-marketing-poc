package com.sap.jnc.marketing.common.model.enums;

import com.sap.jnc.marketing.common.model.ListableEnum;

/**
 * @author I071053 Diouf Du
 * @author I074607 Dean Peng
 */
public enum DeviceType implements ListableEnum {

	SMARTPHONE(1), TABLET(2), DESKTOP(4);

	protected Integer bitmap;

	private DeviceType(Integer bitmap) {
		this.bitmap = bitmap;
	}

	public Integer getBitValue() {
		return this.bitmap;
	}

}
