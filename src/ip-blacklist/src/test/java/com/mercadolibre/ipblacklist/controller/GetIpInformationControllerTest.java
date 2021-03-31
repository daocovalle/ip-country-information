package com.mercadolibre.ipblacklist.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.mercadolibre.ipblacklist.dto.response.BlackListResponseDTO;
import com.mercadolibre.ipblacklist.service.RetrieveIpFromBlackListService;
import com.mercadolibre.ipblacklist.service.util.Constants;

@SpringBootTest
@AutoConfigureMockMvc
public class GetIpInformationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	RetrieveIpFromBlackListService getIpFromBlackListService;

	StringBuilder url = new StringBuilder();

	@BeforeEach
	public void setup() {
		url.append(Constants.RETRIEVE_URL).append(Constants.TEST_IP);
	}

	@Test
	void CountryInformationFromIpNotFound() throws Exception {
		Mockito.when(getIpFromBlackListService.retrieveIpFromBlacklist(Constants.TEST_IP))
				.thenReturn(new BlackListResponseDTO(Constants.IP_NOT_FOUND_STATUS, Constants.IP_NOT_FOUND_MESSAGE));
		mockMvc.perform(get(url.toString())).andExpect(status().isOk());
	}

	@Test
	void CountryInformationFromIpFound() throws Exception {
		Mockito.when(getIpFromBlackListService.retrieveIpFromBlacklist(Constants.TEST_IP))
				.thenReturn(new BlackListResponseDTO(Constants.IP_FOUND_STATUS, Constants.IP_FOUND_MESSAGE));
		mockMvc.perform(get(url.toString())).andExpect(status().isOk());
	}

}
