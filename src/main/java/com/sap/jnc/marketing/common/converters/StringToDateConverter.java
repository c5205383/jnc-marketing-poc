package com.sap.jnc.marketing.common.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

public class StringToDateConverter implements Converter<String, Date> {

	private static final String DATE_FORMAT = "yyyy-MM-dd";
	private static final SimpleDateFormat SDF = new SimpleDateFormat(DATE_FORMAT);

	/*
	 * Implementation Methods
	 */

	@Override
	public Date convert(String dateStr) {
		try {
			return SDF.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		return typeFactory.uncheckedSimpleType(String.class);
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		return typeFactory.uncheckedSimpleType(Date.class);
	}

}