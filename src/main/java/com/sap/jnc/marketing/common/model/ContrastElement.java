package com.sap.jnc.marketing.common.model;

public class ContrastElement<TElement> {

	protected TElement value;
	protected TElement contrast;

	public ContrastElement() {
	}

	public ContrastElement(TElement value) {
		this.value = value;
	}

	public ContrastElement(TElement value, TElement contrast) {
		this.value = value;
		this.contrast = contrast;
	}

	public TElement getValue() {
		return value;
	}

	public void setValue(TElement value) {
		this.value = value;
	}

	public TElement getContrast() {
		return contrast;
	}

	public void setContrast(TElement contrast) {
		this.contrast = contrast;
	}
}
