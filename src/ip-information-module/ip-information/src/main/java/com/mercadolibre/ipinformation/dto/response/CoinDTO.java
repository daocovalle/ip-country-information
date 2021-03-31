package com.mercadolibre.ipinformation.dto.response;

import java.util.Map;

public class CoinDTO {

	private String countryCode;

	private Map<String, Double> coinTransformation;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Map<String, Double> getCoinTransformation() {
		return coinTransformation;
	}

	public void setCoinTransformation(Map<String, Double> coinTransformation) {
		this.coinTransformation = coinTransformation;
	}

}
