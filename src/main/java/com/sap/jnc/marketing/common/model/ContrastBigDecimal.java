package com.sap.jnc.marketing.common.model;

import java.math.BigDecimal;

public class ContrastBigDecimal extends ContrastElement<BigDecimal> {

	public ContrastBigDecimal() {
	}

	public ContrastBigDecimal(BigDecimal value) {
		this.setValue(value);
	}

	public ContrastBigDecimal(BigDecimal value, BigDecimal contrast) {
		this.setValue(value);
		this.setContrast(contrast);
	}

	@Override
	public BigDecimal getValue() {
		if (super.value == null) {
			super.value = new BigDecimal(0);
		}
		return super.value;
	}

	@Override
	public BigDecimal getContrast() {
		if (super.contrast == null) {
			super.contrast = new BigDecimal(0);
		}
		return super.contrast;
	}
}
