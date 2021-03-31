package com.mercadolibre.ipgeolocation.service;

import com.mercadolibre.ipgeolocation.dto.response.GeolocationInfoResponseDTO;

import reactor.core.publisher.Mono;

public interface GeolocationInfoService {
	public Mono<GeolocationInfoResponseDTO> requestGeolocationInformation(String ip);

}
