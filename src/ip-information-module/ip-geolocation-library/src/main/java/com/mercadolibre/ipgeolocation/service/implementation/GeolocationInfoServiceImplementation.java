package com.mercadolibre.ipgeolocation.service.implementation;

import java.time.Duration;

import org.springframework.web.reactive.function.client.WebClient;

import com.mercadolibre.ipgeolocation.configuration.GeolocationConfigurationProperties;
import com.mercadolibre.ipgeolocation.dto.response.GeolocationInfoResponseDTO;
import com.mercadolibre.ipgeolocation.service.GeolocationInfoService;

import reactor.core.publisher.Mono;

public class GeolocationInfoServiceImplementation implements GeolocationInfoService {

	private final WebClient webClient;

	private final GeolocationConfigurationProperties geolocationConfigurationProperties;

	public GeolocationInfoServiceImplementation(WebClient webClient,
			GeolocationConfigurationProperties geolocationConfigurationProperties) {
		super();
		this.webClient = webClient;
		this.geolocationConfigurationProperties = geolocationConfigurationProperties;
	}

	@Override
	public Mono<GeolocationInfoResponseDTO> requestGeolocationInformation(String ip) {

		StringBuilder url = new StringBuilder();
		url.append(geolocationConfigurationProperties.getUrl()).append(ip);
		return webClient.get().uri(url.toString()).retrieve().bodyToMono(GeolocationInfoResponseDTO.class)
				.timeout(Duration.ofMillis(30000));

	}

}
