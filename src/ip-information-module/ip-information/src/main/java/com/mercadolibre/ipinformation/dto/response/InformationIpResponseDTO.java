package com.mercadolibre.ipinformation.dto.response;

import java.util.List;

public class InformationIpResponseDTO {

	private String countryName;

	private String IsoCode;

	private List<CoinDTO> coins;

	public List<CoinDTO> getCoins() {
		return coins;
	}

	public void setCoins(List<CoinDTO> coins) {
		this.coins = coins;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getIsoCode() {
		return IsoCode;
	}

	public void setIsoCode(String isoCode) {
		IsoCode = isoCode;
	}

}
