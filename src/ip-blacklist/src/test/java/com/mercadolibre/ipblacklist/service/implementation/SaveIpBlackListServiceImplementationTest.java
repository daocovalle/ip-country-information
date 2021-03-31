package com.mercadolibre.ipblacklist.service.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.ipblacklist.db.entity.BlackListIpEntity;
import com.mercadolibre.ipblacklist.db.repository.BlackListIPRepository;
import com.mercadolibre.ipblacklist.dto.response.BlackListResponseDTO;
import com.mercadolibre.ipblacklist.service.util.Constants;

@ExtendWith(MockitoExtension.class)
class SaveIpBlackListServiceImplementationTest {

	@Mock
	BlackListIPRepository blackListIPRepository;

	@InjectMocks
	SaveIpBlackListServiceImplementation saveIpBlackListServiceImplementation;

	@Test
	void validateBlackListIPResponseSuccess() {
		BlackListIpEntity ipEntity = new BlackListIpEntity();
		ipEntity.setIpNumber(Constants.TEST_IP);
		Date date = new Date();
		ipEntity.setRegisterDate(new Timestamp(date.getTime()));
		lenient().when(blackListIPRepository.save(ipEntity)).thenReturn(ipEntity);
		BlackListResponseDTO response = saveIpBlackListServiceImplementation.saveIpInBlackList(Constants.TEST_IP);
		assertEquals(response.getStatusCode(), Constants.SAVED_STATUS);

	}
}
