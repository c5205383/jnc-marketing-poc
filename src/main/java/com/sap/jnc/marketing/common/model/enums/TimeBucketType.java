package com.sap.jnc.marketing.common.model.enums;

import com.sap.jnc.marketing.common.model.ListableEnum;

/**
 * Flag the aggregation level of time unit for aggregation key within specific entry.
 *
 * @author I071053 Diouf Du
 */
public enum TimeBucketType implements ListableEnum {

	/**
	 * Mark the aggregated value since last hour past, new entry created with the aggregate value added on real time (depends on the time
	 * span on scheduler execution).
	 */
	HOUR("Hour"),

	/**
	 * Mark the total value since business object activate, update include the aggregate value on real time (depends on the time span on
	 * scheduler execution).
	 */
	TOTAL("Total");

	/** The short but meaningful name for this enum. */
	private String name;

	private TimeBucketType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
