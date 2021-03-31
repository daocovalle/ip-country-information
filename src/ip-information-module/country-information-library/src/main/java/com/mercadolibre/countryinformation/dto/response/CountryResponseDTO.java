
package com.mercadolibre.countryinformation.dto.response;

import java.util.List;
import java.util.Map;

public class CountryResponseDTO {

	public String name;
	public List<String> topLevelDomain;
	public String alpha2Code;
	public String alpha3Code;
	public List<String> callingCodes;
	public String capital;
	public List<String> altSpellings;
	public String region;
	public String subregion;
	public Long population;
	public List<Double> latlng;
	public String demonym;
	public Double area;
	public Double gini;
	public List<String> timezones;
	public List<String> borders;
	public String nativeName;
	public Integer numericCode;
	public List<Currency> currencies;
	public List<Languages> languages;
	public Map<String, String> translations;
	public String flag;
	public List<RegionalBlocs> regionalBlocs;
	public String cioc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTopLevelDomain() {
		return topLevelDomain;
	}

	public void setTopLevelDomain(List<String> topLevelDomain) {
		this.topLevelDomain = topLevelDomain;
	}

	public String getAlpha2Code() {
		return alpha2Code;
	}

	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}

	public String getAlpha3Code() {
		return alpha3Code;
	}

	public void setAlpha3Code(String alpha3Code) {
		this.alpha3Code = alpha3Code;
	}

	public List<String> getCallingCodes() {
		return callingCodes;
	}

	public void setCallingCodes(List<String> callingCodes) {
		this.callingCodes = callingCodes;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public List<String> getAltSpellings() {
		return altSpellings;
	}

	public void setAltSpellings(List<String> altSpellings) {
		this.altSpellings = altSpellings;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSubregion() {
		return subregion;
	}

	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public List<Double> getLatlng() {
		return latlng;
	}

	public void setLatlng(List<Double> latlng) {
		this.latlng = latlng;
	}

	public String getDemonym() {
		return demonym;
	}

	public void setDemonym(String demonym) {
		this.demonym = demonym;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Double getGini() {
		return gini;
	}

	public void setGini(Double gini) {
		this.gini = gini;
	}

	public List<String> getTimezones() {
		return timezones;
	}

	public void setTimezones(List<String> timezones) {
		this.timezones = timezones;
	}

	public List<String> getBorders() {
		return borders;
	}

	public void setBorders(List<String> borders) {
		this.borders = borders;
	}

	public String getNativeName() {
		return nativeName;
	}

	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}

	public Integer getNumericCode() {
		return numericCode;
	}

	public void setNumericCode(Integer numericCode) {
		this.numericCode = numericCode;
	}

	public List<Currency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}

	public List<Languages> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Languages> languages) {
		this.languages = languages;
	}

	public Map<String, String> getTranslations() {
		return translations;
	}

	public void setTranslations(Map<String, String> translations) {
		this.translations = translations;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<RegionalBlocs> getRegionalBlocs() {
		return regionalBlocs;
	}

	public void setRegionalBlocs(List<RegionalBlocs> regionalBlocs) {
		this.regionalBlocs = regionalBlocs;
	}

	public String getCioc() {
		return cioc;
	}

	public void setCioc(String cioc) {
		this.cioc = cioc;
	}

}
