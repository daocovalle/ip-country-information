
package com.mercadolibre.countryinformation.service;

import com.mercadolibre.countryinformation.dto.response.CountryResponseDTO;

import reactor.core.publisher.Mono;

public interface CountryService {
	Mono<CountryResponseDTO> requestCountryInformation(String isoCode);

}
