package com.sap.jnc.marketing.common.model.enums;

import com.sap.jnc.marketing.common.model.ListableEnum;

/**
 * Enumeration of technologies used to "bust" an advertisement out of an iframe on an HTML page.
 * 
 * @author Janosch Fock
 */
public enum IframeBustingTechnology implements ListableEnum {

	POINTROLL("Pr"), 
	EYEBLASTER("Eb"), 
	DOUBLE_CLICK("Dc"), 
	EYE_WONDER("Ew"), 
	MEDIAPLEX("Mp"), 
	VIEWPOINT("Vp"), 
	UNICAST("Ui"), 
	SMART_ADSERVER("Sa"), 
	KLIPMART("Km"), 
	EYE_RETURN("Er"), 
	ATLAS("At"), 
	ADINTERAX("Ad"), 
	ADCENTRIC("Ac"), 
	FLASHTALKING("Ft"), 
	MEDIA_MIND("Mm"), 
	PICTELA("Pt");

	/**
	 * Abbreviated key that is being used by SSP PubMatic.
	 */
	private final String pubmaticKey;

	private IframeBustingTechnology(final String pubmaticKey) {
		this.pubmaticKey = pubmaticKey;
	}

	/**
	 * Returns the value of field <code>{@link #pubmaticKey}</code>.
	 *
	 * @return the pubmaticKey
	 */
	public String getPubmaticKey() {
		return this.pubmaticKey;
	}

}
