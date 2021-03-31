package com.mercadolibre.ipinformation.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.mercadolibre.blacklist.dto.response.BlackListResponseDTO;
import com.mercadolibre.coininformation.dto.response.CoinInfoResponseDTO;
import com.mercadolibre.countryinformation.dto.response.CountryResponseDTO;
import com.mercadolibre.countryinformation.dto.response.Currency;
import com.mercadolibre.countryinformation.dto.response.Languages;
import com.mercadolibre.countryinformation.dto.response.RegionalBlocs;
import com.mercadolibre.ipgeolocation.dto.response.GeolocationInfoResponseDTO;
import com.mercadolibre.ipinformation.dto.response.CoinDTO;
import com.mercadolibre.ipinformation.dto.response.InformationIpResponseDTO;

public class BuildObjects {

	public static final String COUNTRY_INFO_URL = "/country-information";
	public static final String TEST_IP = "2.22.160.0";
	public static final String COUNTRY_NAME = "France";
	public static final String ISO_CODE3 = "FRA";
	public static final String CURRENCY_EUR = "EUR";
	public static final String SYMBOLS = "usd,eur";

	public static CountryResponseDTO buildCountryResponse() {
		CountryResponseDTO expectedCountry = new CountryResponseDTO();

		Currency currency = new Currency();
		currency.setCode("EUR");
		currency.setName("Euro");
		currency.setSymbol("e");

		Languages languages = new Languages();
		languages.setIso639_1("fr");
		languages.setIso639_2("fra");
		languages.setName("French");
		languages.setNativeName("francais");

		expectedCountry.setAlpha2Code("FR");
		expectedCountry.setAlpha3Code("FRA");
		expectedCountry.setAltSpellings(Arrays.asList("FR", "French Republic", "Republique francaise"));
		expectedCountry.setArea(640679.0);
		expectedCountry.setBorders(Arrays.asList("AND", "BEL", "DEU", "ITA", "LUX", "MCO", "ESP", "CHE"));
		expectedCountry.setCallingCodes(Arrays.asList("33"));
		expectedCountry.setCapital("Paris");
		expectedCountry.setCioc("cioc");
		expectedCountry.setCurrencies(Arrays.asList(currency));
		expectedCountry.setDemonym("French");
		expectedCountry.setFlag("https://restcountries.eu/data/fra.svg");
		expectedCountry.setGini(32.7);
		expectedCountry.setLanguages(Arrays.asList(languages));
		expectedCountry.setLatlng(Arrays.asList(46.2, 2.0));
		expectedCountry.setName("France");
		expectedCountry.setNativeName("France");
		expectedCountry.setNumericCode(250);
		expectedCountry.setPopulation(66710000L);
		expectedCountry.setRegion("Europe");
		expectedCountry.setRegionalBlocs(Arrays.asList(new RegionalBlocs()));
		expectedCountry.setSubregion("Western Europe");
		expectedCountry.setTimezones(Arrays.asList("UTC-10:00", "UTC-09:30", "UTC-09:00", "UTC-08:00", "UTC-04:00",
				"UTC-03:00", "UTC+01:00", "UTC+03:00", "UTC+04:00", "UTC+05:00", "UTC+11:00", "UTC+12:00"));
		expectedCountry.setTopLevelDomain(null);
		expectedCountry.setTranslations(new HashMap<>());
		return expectedCountry;
	}

	public static CoinInfoResponseDTO buildCoinInfoResponse() {

		CoinInfoResponseDTO coinInfoResponseDTO = new CoinInfoResponseDTO();
		coinInfoResponseDTO.setBase("EUR");
		coinInfoResponseDTO.setDate("2021-03-29");
		coinInfoResponseDTO.setRates(Map.of("EUR", 1.0, "USD", 1.177297));
		coinInfoResponseDTO.setSuccess(true);
		coinInfoResponseDTO.setTimestamp(1617056286);

		return coinInfoResponseDTO;
	}

	public static GeolocationInfoResponseDTO buildGeolocationInfoResponse() {
		GeolocationInfoResponseDTO geolocationInfoResponseDTO = new GeolocationInfoResponseDTO();

		geolocationInfoResponseDTO.setCountryCode("FR");
		geolocationInfoResponseDTO.setCountryCode3("FRA");
		geolocationInfoResponseDTO.setCountryEmoji("ff");
		geolocationInfoResponseDTO.setCountryName("France");

		return geolocationInfoResponseDTO;
	}

	public static BlackListResponseDTO buildNotFoundBlackListResponse() {
		BlackListResponseDTO blackListResponseDTO = new BlackListResponseDTO();
		blackListResponseDTO.setMessage("IP not Found");
		blackListResponseDTO.setStatusCode(1);
		return blackListResponseDTO;
	}

	public static BlackListResponseDTO builFoundBlackListResponse() {
		BlackListResponseDTO blackListResponseDTO = new BlackListResponseDTO();
		blackListResponseDTO.setMessage("IP Found");
		blackListResponseDTO.setStatusCode(0);
		return blackListResponseDTO;
	}

	public static InformationIpResponseDTO buildInformationIpResponse() {
		InformationIpResponseDTO informationIpResponseDTO = new InformationIpResponseDTO();
		informationIpResponseDTO.setIsoCode("FRA");
		informationIpResponseDTO.setCountryName("France");

		CoinDTO coinDTO = new CoinDTO();
		coinDTO.setCountryCode("EUR");
		coinDTO.setCoinTransformation(Map.of("USD", 1.175302, "EUR", 1.0));
		informationIpResponseDTO.setCoins(Arrays.asList(coinDTO));
		return informationIpResponseDTO;

	}
}
