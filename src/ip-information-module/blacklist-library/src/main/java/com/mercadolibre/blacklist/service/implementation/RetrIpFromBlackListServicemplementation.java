package com.mercadolibre.blacklist.service.implementation;

import java.time.Duration;

import org.springframework.web.reactive.function.client.WebClient;

import com.mercadolibre.blacklist.configuration.BlackListConfigurationProperties;
import com.mercadolibre.blacklist.dto.response.BlackListResponseDTO;
import com.mercadolibre.blacklist.service.GetIpFromBlackListService;
import com.mercadolibre.blacklist.util.Constants;

import reactor.core.publisher.Mono;

public class RetrIpFromBlackListServicemplementation implements GetIpFromBlackListService {

	private final WebClient webClient;

	private final BlackListConfigurationProperties configurations;

	public RetrIpFromBlackListServicemplementation(WebClient webClient,
			BlackListConfigurationProperties configurations) {
		super();
		this.webClient = webClient;
		this.configurations = configurations;
	}

	@Override
	public Mono<BlackListResponseDTO> retrieveIpFromBlacklist(String ip) {
		StringBuilder sb = new StringBuilder();
		sb.append(configurations.getUrl()).append(Constants.QUESTION_MARK).append(Constants.IP)
				.append(Constants.EQUAL_SYMBOL).append(ip);

		return webClient.get().uri(sb.toString()).retrieve().bodyToMono(BlackListResponseDTO.class)
				.timeout(Duration.ofMillis(30000));
	}

}
