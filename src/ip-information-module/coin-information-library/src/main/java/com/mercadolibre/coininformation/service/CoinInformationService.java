package com.mercadolibre.coininformation.service;

import com.mercadolibre.coininformation.dto.response.CoinInfoResponseDTO;

import reactor.core.publisher.Mono;

public interface CoinInformationService {
	Mono<CoinInfoResponseDTO> requestCoinInformation(String base, String simbols);

}
