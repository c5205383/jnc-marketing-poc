/**
 *
 */
package com.sap.jnc.marketing.common.model;

import java.io.Serializable;

/**
 * @author I071053 Diouf Du
 */
public interface ContractRange<TElement extends Comparable<TElement>> extends Serializable {

	TElement getStartInclusive();

	TElement getEndInclusive();
}
