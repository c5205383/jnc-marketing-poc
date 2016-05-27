package com.sap.jnc.marketing.config;

public interface ConfigProperty {

	ConfigPropertyType getType();

	boolean getBooleanValue();

	int getIntValue();

	long getLongValue();

	double getDoubleValue();

	String getStringValue();

}
