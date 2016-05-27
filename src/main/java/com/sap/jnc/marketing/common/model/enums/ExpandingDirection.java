package com.sap.jnc.marketing.common.model.enums;

import com.sap.jnc.marketing.common.model.ListableEnum;

/**
 * Enumeration of directions in which a rich media advertisement can expand.
 * 
 * @author Janosch Fock
 */
public enum ExpandingDirection implements ListableEnum {

	LEFT(1), RIGHT(2), UP(4), DOWN(8), FULL_SCREEN(16);

	private final int bitValue;

	ExpandingDirection(int bitValue) {
		this.bitValue = bitValue;
	}

	/**
	 * Returns the value of field <code>{@link #bitValue}</code>.
	 *
	 * @return the bitValue
	 */
	public int getBitValue() {
		return this.bitValue;
	}

}
