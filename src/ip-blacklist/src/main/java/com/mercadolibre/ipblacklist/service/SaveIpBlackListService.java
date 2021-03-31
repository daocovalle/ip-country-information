package com.mercadolibre.ipblacklist.service;

import com.mercadolibre.ipblacklist.dto.response.BlackListResponseDTO;

public interface SaveIpBlackListService {

	public BlackListResponseDTO saveIpInBlackList(String ip);
}
