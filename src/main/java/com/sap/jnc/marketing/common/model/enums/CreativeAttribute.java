package com.sap.jnc.marketing.common.model.enums;

import com.sap.jnc.marketing.common.model.ListableEnum;

/**
 * Creative attributes.
 * 
 * @author Dean Peng
 */
public enum CreativeAttribute implements ListableEnum {
	AUDIO_AD_AUDIO_PLAY(1), AUDIO_AD_USER_INITIATED(2), EXPANDABLE_AUTOMATIC(4), EXPANDABLE_USER_INITIATED_CLICK(
			8), EXPANDABLE_USER_INITIATED_ROLLOVER(16), IN_BANNER_VIDEO_AD_AUTO_PLAY(32), IN_BANNER_VIDEO_AD_USER_INITIATED(64), POP(
					128), PROVOCATIVE_OR_SUGGESTIVE_IMAGERY(256), SHAKY_FLASHING_FLICKERING(512), SURVEYS(1024), TEXT_ONLY(
							2048), USER_INTERACTIVE(4096), WINDOW_DIALOG(8192), HAS_AUDIO_ON_OFF_BUTTON(16384), CAN_BE_SKIPPED(32768);

	private int bitValue;

	private CreativeAttribute(int bitmap) {
		this.bitValue = bitmap;
	}

	public int getBitValue() {
		return bitValue;
	}

}
