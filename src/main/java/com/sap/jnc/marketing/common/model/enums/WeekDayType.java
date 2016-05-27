package com.sap.jnc.marketing.common.model.enums;

import com.sap.jnc.marketing.common.model.ListableEnum;

/**
 * @author I074607
 * @createDate Jul 6, 2015
 */
public enum WeekDayType implements ListableEnum {

	MONDAY(1), TUESDAY(2), WEDNESDAY(4), THURSDAY(8), FRIDAY(16), SATURDAY(32), SUNDAY(64);

	protected Integer bitmap;

	private WeekDayType(Integer bitmap) {
		this.bitmap = bitmap;
	}

	public Integer getBitValue() {
		return this.bitmap;
	}

	/**
	 * Converts a Calendar day into the corresponding WeekdayType
	 * 
	 * @param param
	 *            the Calendar day integer
	 * @return the WeekDayType that corresponds to the given Calendar day
	 */
	public static WeekDayType fromCalendarDay(int param) {
		for (WeekDayType weekday : WeekDayType.values()) {
			// the enum starts with Monday, but Calendar starts with Sunday,
			// so we need to translate
			if ((param - 2 + 7) % 7 == weekday.ordinal()) {
				return weekday;
			}
		}
		return null;
	}

}
