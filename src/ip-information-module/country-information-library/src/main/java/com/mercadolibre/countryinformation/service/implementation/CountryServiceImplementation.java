
package com.mercadolibre.countryinformation.service.implementation;

import java.time.Duration;

import org.springframework.web.reactive.function.client.WebClient;

import com.mercadolibre.countryinformation.configuration.CountryConfigurationProperties;
import com.mercadolibre.countryinformation.dto.response.CountryResponseDTO;
import com.mercadolibre.countryinformation.service.CountryService;

import reactor.core.publisher.Mono;

public class CountryServiceImplementation implements CountryService {

	private final WebClient webClient;

	private final CountryConfigurationProperties geolocationConfigurationProperties;

	public CountryServiceImplementation(WebClient webClient,
			CountryConfigurationProperties geolocationConfigurationProperties) {
		super();
		this.webClient = webClient;
		this.geolocationConfigurationProperties = geolocationConfigurationProperties;
	}

	@Override
	public Mono<CountryResponseDTO> requestCountryInformation(String ip) {
		StringBuilder sb = new StringBuilder();
		sb.append(geolocationConfigurationProperties.getUrl()).append(ip);
		return webClient.get().uri(sb.toString()).retrieve().bodyToMono(CountryResponseDTO.class)
				.timeout(Duration.ofMillis(30000));

	}

}
