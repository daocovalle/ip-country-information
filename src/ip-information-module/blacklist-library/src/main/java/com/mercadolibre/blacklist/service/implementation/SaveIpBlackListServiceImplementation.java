package com.mercadolibre.blacklist.service.implementation;

import java.time.Duration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.mercadolibre.blacklist.configuration.BlackListConfigurationProperties;
import com.mercadolibre.blacklist.dto.request.BlackListIpRequestDTO;
import com.mercadolibre.blacklist.dto.response.BlackListResponseDTO;
import com.mercadolibre.blacklist.service.SaveIpBlackListService;

import reactor.core.publisher.Mono;

public class SaveIpBlackListServiceImplementation implements SaveIpBlackListService {

	private final WebClient webClient;

	private final BlackListConfigurationProperties configurations;

	public SaveIpBlackListServiceImplementation(WebClient webClient, BlackListConfigurationProperties configurations) {
		super();
		this.webClient = webClient;
		this.configurations = configurations;
	}

	@Override
	public Mono<BlackListResponseDTO> saveIpInBlackList(BlackListIpRequestDTO blackListIp) {
		return webClient.post().uri(configurations.getUrl())
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(blackListIp), BlackListIpRequestDTO.class).retrieve()
				.bodyToMono(BlackListResponseDTO.class).timeout(Duration.ofMillis(30000));
	}

}
