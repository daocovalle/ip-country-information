package com.mercadolibre.blacklist.service;

import com.mercadolibre.blacklist.dto.request.BlackListIpRequestDTO;
import com.mercadolibre.blacklist.dto.response.BlackListResponseDTO;

import reactor.core.publisher.Mono;

public interface SaveIpBlackListService {

	public Mono<BlackListResponseDTO> saveIpInBlackList(BlackListIpRequestDTO ip);
}
