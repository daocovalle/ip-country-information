package com.mercadolibre.ipblacklist.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.ipblacklist.db.entity.BlackListIpEntity;
import com.mercadolibre.ipblacklist.db.repository.BlackListIPRepository;
import com.mercadolibre.ipblacklist.dto.response.BlackListResponseDTO;
import com.mercadolibre.ipblacklist.service.RetrieveIpFromBlackListService;
import com.mercadolibre.ipblacklist.util.Constants;
import com.mercadolibre.ipblacklist.util.Utils;

@Service
public class RetrieveIpFromBlackListServiceImplementation implements RetrieveIpFromBlackListService {

	@Autowired
	BlackListIPRepository blackListIPRepository;

	Logger logger = LoggerFactory.getLogger(RetrieveIpFromBlackListServiceImplementation.class);

	@Override
	public BlackListResponseDTO retrieveIpFromBlacklist(String ip) {
		logger.info("retrieving IP == {}", ip);
		BlackListIpEntity retrievedIp = blackListIPRepository.findByIpNumber(ip);
		logger.info("retrieving IP ==  {}", Utils.mapObject(retrievedIp));
		if (retrievedIp == null) {
			return new BlackListResponseDTO(Constants.NOT_FOUND_IP_STATUS, Constants.IP_NOT_FOUND_MESSAGE);
		}
		return new BlackListResponseDTO(Constants.IP_FOUND_STATUS, Constants.IP_FOUND_MESSAGE);
	}

}
