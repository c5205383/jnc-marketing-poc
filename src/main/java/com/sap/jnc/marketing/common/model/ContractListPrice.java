package com.sap.jnc.marketing.common.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author I071053 Diouf Du
 */
public interface ContractListPrice extends Serializable {

	BigDecimal getAmount();

	String getUnit();
}
