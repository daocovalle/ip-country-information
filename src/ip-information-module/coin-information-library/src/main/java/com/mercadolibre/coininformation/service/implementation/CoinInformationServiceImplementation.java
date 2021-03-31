package com.mercadolibre.coininformation.service.implementation;

import java.time.Duration;

import org.springframework.web.reactive.function.client.WebClient;

import com.mercadolibre.coininformation.configuration.CoinConfigurationProperties;
import com.mercadolibre.coininformation.dto.response.CoinInfoResponseDTO;
import com.mercadolibre.coininformation.service.CoinInformationService;
import com.mercadolibre.coininformation.util.Constants;

import reactor.core.publisher.Mono;

public class CoinInformationServiceImplementation implements CoinInformationService {

	private final WebClient webClient;

	private final CoinConfigurationProperties configurations;

	public CoinInformationServiceImplementation(WebClient webClient, CoinConfigurationProperties configurations) {
		super();
		this.webClient = webClient;
		this.configurations = configurations;
	}

	@Override
	public Mono<CoinInfoResponseDTO> requestCoinInformation(String base, String simbols) {

		StringBuilder sb = new StringBuilder();
		sb.append(configurations.getUrl()).append(Constants.QUESTION_MARK).append(configurations.getParamKey())
				.append(Constants.EQUAL_SYMBOL).append(configurations.getParamValue()).append(Constants.AMPERSAND)
				.append(Constants.BASE).append(Constants.EQUAL_SYMBOL).append(base);
		if (simbols.length() > 1) {
			sb.append(Constants.AMPERSAND).append(Constants.SYMBOLS).append(Constants.EQUAL_SYMBOL).append(simbols);
		}

		return webClient.get().uri(sb.toString()).retrieve().bodyToMono(CoinInfoResponseDTO.class)
				.timeout(Duration.ofMillis(30000));
	}

}
