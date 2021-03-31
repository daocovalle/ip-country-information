package com.mercadolibre.ipblacklist.service.implementation;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.ipblacklist.db.entity.BlackListIpEntity;
import com.mercadolibre.ipblacklist.db.repository.BlackListIPRepository;
import com.mercadolibre.ipblacklist.dto.response.BlackListResponseDTO;
import com.mercadolibre.ipblacklist.service.SaveIpBlackListService;
import com.mercadolibre.ipblacklist.util.Constants;
import com.mercadolibre.ipblacklist.util.Utils;

@Service
public class SaveIpBlackListServiceImplementation implements SaveIpBlackListService {

	@Autowired
	BlackListIPRepository blackListIPRepository;

	Logger logger = LoggerFactory.getLogger(SaveIpBlackListServiceImplementation.class);

	@Override
	public BlackListResponseDTO saveIpInBlackList(String ip) {
		BlackListIpEntity ipEntity = new BlackListIpEntity();
		ipEntity.setIpNumber(ip);
		Date date = new Date();
		ipEntity.setRegisterDate(new Timestamp(date.getTime()));
		logger.info("Saving ip == {}", Utils.mapObject(ipEntity));
		blackListIPRepository.save(ipEntity);
		return new BlackListResponseDTO(Constants.SAVED_STATUS, Constants.SAVED_MESSAGE);
	}
}
