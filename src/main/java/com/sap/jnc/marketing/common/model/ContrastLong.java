package com.sap.jnc.marketing.common.model;

public class ContrastLong extends ContrastElement<Long> {

	public ContrastLong() {
	}

	public ContrastLong(Long value) {
		this.setValue(value);
	}

	public ContrastLong(Long value, Long contrast) {
		this.setValue(value);
		this.setContrast(contrast);
	}

	@Override
	public Long getValue() {
		if (super.value == null) {
			super.value = 0L;
		}
		return super.value;
	}

	@Override
	public Long getContrast() {
		if (super.contrast == null) {
			super.contrast = 0L;
		}
		return super.contrast;
	}
}
