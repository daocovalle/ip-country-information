
package com.mercadolibre.countryinformation.dto.response;

import java.util.List;

public class RegionalBlocs {

	public String acronym;
	public String name;
	public List<String> otherAcronyms;
	public List<String> otherNames;

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getOtherAcronyms() {
		return otherAcronyms;
	}

	public void setOtherAcronyms(List<String> otherAcronyms) {
		this.otherAcronyms = otherAcronyms;
	}

	public List<String> getOtherNames() {
		return otherNames;
	}

	public void setOtherNames(List<String> otherNames) {
		this.otherNames = otherNames;
	}

}
