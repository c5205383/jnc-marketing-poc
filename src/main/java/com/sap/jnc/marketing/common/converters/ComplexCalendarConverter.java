package com.sap.jnc.marketing.common.converters;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

public class ComplexCalendarConverter implements Converter<Calendar, String> {

	private static final String DATE_FORMAT = "YYYY-MM-DD HH:mm:SS.FFFFFFF";
	private static final SimpleDateFormat SDF = new SimpleDateFormat(DATE_FORMAT);

	/*
	 * Implementation Methods
	 */

	@Override
	public String convert(Calendar calendar) {
		return SDF.format(calendar.getTime());
	}

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		return typeFactory.uncheckedSimpleType(Calendar.class);
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		return typeFactory.uncheckedSimpleType(String.class);
	}

}
