package com.sap.jnc.marketing.common.model.enums;

import com.sap.jnc.marketing.common.model.ListableEnum;

/**
 * This enum used for device targeting to indicate the relation of device os version.
 *
 * @author I075496 Quansheng Liu
 */
public enum DeviceOsVersionRelationType implements ListableEnum {
	OLDER, MATCH, NEWER, ANDNEWER, ANDOLDER;
}
