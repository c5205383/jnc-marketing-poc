package com.sap.jnc.marketing.persistence.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"jncpf2::data_column.wine\"", schema = "JNC")
public class Wine implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "\"ID\"")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected String id;
	
	@Column(name = "\"flagBonusA\"")
	protected char flagBonusA;
	
	@Column(name = "\"amountA\"")
	protected Integer amountA;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public char getFlagBonusA() {
		return flagBonusA;
	}

	public void setFlagBonusA(char flagBonusA) {
		this.flagBonusA = flagBonusA;
	}

	public Integer getAmountA() {
		return amountA;
	}

	public void setAmountA(Integer amountA) {
		this.amountA = amountA;
	}
	
}
