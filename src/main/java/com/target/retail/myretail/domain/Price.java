package com.target.retail.myretail.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Price {
	
	private double value;
	private String currency;
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@JsonProperty("currency_code")
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
