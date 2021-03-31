package com.mercadolibre.ipblacklist.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.ipblacklist.dto.request.IPBlacklistRequestDTO;
import com.mercadolibre.ipblacklist.dto.response.BlackListResponseDTO;
import com.mercadolibre.ipblacklist.service.SaveIpBlackListService;
import com.mercadolibre.ipblacklist.service.util.Constants;

@SpringBootTest
@AutoConfigureMockMvc
class SaveIpInformationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	SaveIpBlackListService saveIpBlackListService;

	@Test
	void SaveBlackListIpSuccess() throws Exception {
		IPBlacklistRequestDTO ipBlackList = new IPBlacklistRequestDTO();
		ipBlackList.setIp(Constants.TEST_IP);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(ipBlackList);
		Mockito.when(saveIpBlackListService.saveIpInBlackList(Constants.TEST_IP))
				.thenReturn(new BlackListResponseDTO(Constants.SAVED_STATUS, Constants.SAVED_MESSAGE));
		mockMvc.perform(post(Constants.SAVE_URL).contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(status().isCreated());
	}

	@Test
	void SaveBlackListIpBad() throws Exception {
		mockMvc.perform(post(Constants.SAVE_URL)).andExpect(status().isBadRequest());
	}
}
