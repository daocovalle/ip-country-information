package com.mercadolibre.coininformation.dto.response;

import java.util.Map;

public class Rates {
	private Map<String, Double> rates;

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}

}
