package com.sap.jnc.marketing.common.converters;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

public class DateToStringConverter implements Converter<Date, String> {

	private static final String DATE_FORMAT = "yyyy-MM-dd";
	private static final SimpleDateFormat SDF = new SimpleDateFormat(DATE_FORMAT);

	/*
	 * Implementation Methods
	 */

	@Override
	public String convert(Date date) {
		return SDF.format(date);
	}

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		return typeFactory.uncheckedSimpleType(Date.class);
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		return typeFactory.uncheckedSimpleType(String.class);
	}

}