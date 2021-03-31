package com.mercadolibre.blacklist.service;

import com.mercadolibre.blacklist.dto.response.BlackListResponseDTO;

import reactor.core.publisher.Mono;

public interface GetIpFromBlackListService {
	Mono<BlackListResponseDTO> retrieveIpFromBlacklist(String ip);

}
