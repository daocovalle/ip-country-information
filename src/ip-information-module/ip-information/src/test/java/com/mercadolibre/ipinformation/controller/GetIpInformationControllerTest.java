package com.mercadolibre.ipinformation.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.mercadolibre.ipinformation.service.GetIpInformationService;
import com.mercadolibre.ipinformation.util.BuildObjects;

@SpringBootTest
@AutoConfigureMockMvc
public class GetIpInformationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	GetIpInformationService getIpInformationService;

	StringBuilder url = new StringBuilder();

	@Test
	public void CountryInformationFromIpSuccess() throws Exception {
		url.append(BuildObjects.COUNTRY_INFO_URL).append("?ip=").append(BuildObjects.TEST_IP);
		Mockito.when(getIpInformationService.getIPInformation(BuildObjects.TEST_IP))
				.thenReturn(BuildObjects.buildInformationIpResponse());
		mockMvc.perform(get(url.toString())).andExpect(status().isOk());
	}

	@Test
	public void CountryInformationFromIpBad() throws Exception {
		Mockito.when(getIpInformationService.getIPInformation(BuildObjects.TEST_IP))
				.thenReturn(BuildObjects.buildInformationIpResponse());
		mockMvc.perform(get(BuildObjects.COUNTRY_INFO_URL)).andExpect(status().isBadRequest());
	}

}
