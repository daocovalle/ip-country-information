package com.mercadolibre.ipinformation.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import com.mercadolibre.blacklist.configuration.BlackListConfigurationProperties;
import com.mercadolibre.blacklist.service.implementation.RetrIpFromBlackListServicemplementation;
import com.mercadolibre.blacklist.service.implementation.SaveIpBlackListServiceImplementation;
import com.mercadolibre.coininformation.configuration.CoinConfigurationProperties;
import com.mercadolibre.coininformation.service.implementation.CoinInformationServiceImplementation;
import com.mercadolibre.countryinformation.configuration.CountryConfigurationProperties;
import com.mercadolibre.countryinformation.service.implementation.CountryServiceImplementation;
import com.mercadolibre.ipgeolocation.configuration.GeolocationConfigurationProperties;
import com.mercadolibre.ipgeolocation.service.implementation.GeolocationInfoServiceImplementation;

import reactor.core.publisher.Mono;

@Configuration
public class BeansConfiguration {

	static Logger logger = LoggerFactory.getLogger(BeansConfiguration.class);

	@Bean
	public WebClient webClientConfiguration() {
		return WebClient.builder().filter(logRequest()).build();
	}

	@Bean
	public CoinInformationServiceImplementation coinInfoConfiguration(WebClient webClient,
			CoinConfigurationProperties configurations) {
		return new CoinInformationServiceImplementation(webClient, configurations);

	}

	@Bean
	public CountryServiceImplementation countryInfoConfiguration(WebClient webClient,
			CountryConfigurationProperties configurations) {
		return new CountryServiceImplementation(webClient, configurations);

	}

	@Bean
	public GeolocationInfoServiceImplementation geolocationInfoConfiguration(WebClient webClient,
			GeolocationConfigurationProperties configurations) {
		return new GeolocationInfoServiceImplementation(webClient, configurations);

	}

	@Bean
	public RetrIpFromBlackListServicemplementation blackListConfiguration(WebClient webClient,
			BlackListConfigurationProperties configurations) {
		return new RetrIpFromBlackListServicemplementation(webClient, configurations);

	}

	@Bean
	public SaveIpBlackListServiceImplementation saveBlackListConfiguration(WebClient webClient,
			BlackListConfigurationProperties configurations) {
		return new SaveIpBlackListServiceImplementation(webClient, configurations);

	}

	// This method returns filter function which will log request data
	private static ExchangeFilterFunction logRequest() {
		return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
			logger.info("Request: {} {}", clientRequest.method(), clientRequest.url());
			clientRequest.headers()
					.forEach((name, values) -> values.forEach(value -> logger.info("{}={}", name, value)));
			return Mono.just(clientRequest);
		});
	}
}
