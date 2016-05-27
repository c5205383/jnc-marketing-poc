package com.sap.jnc.marketing.common.converters;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

public class StringFormattedConverter implements Converter<Number, String> {

	/*
	 * Implementation Methods
	 */

	@Override
	public String convert(Number number) {
		return String.valueOf(number);
	}

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		return typeFactory.uncheckedSimpleType(Number.class);
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		return typeFactory.uncheckedSimpleType(String.class);
	}

}
