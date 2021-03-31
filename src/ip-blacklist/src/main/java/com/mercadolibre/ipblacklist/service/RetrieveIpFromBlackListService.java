package com.mercadolibre.ipblacklist.service;

import com.mercadolibre.ipblacklist.dto.response.BlackListResponseDTO;

public interface RetrieveIpFromBlackListService {

	public BlackListResponseDTO retrieveIpFromBlacklist(String ip);
}
