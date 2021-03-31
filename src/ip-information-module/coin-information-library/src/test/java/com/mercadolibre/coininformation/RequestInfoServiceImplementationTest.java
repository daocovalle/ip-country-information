package com.mercadolibre.coininformation;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.mercadolibre.coininformation.configuration.CoinConfigurationProperties;
import com.mercadolibre.coininformation.dto.response.CoinInfoResponseDTO;
import com.mercadolibre.coininformation.service.implementation.CoinInformationServiceImplementation;
import com.mercadolibre.coininformation.util.Util;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

@ExtendWith(MockitoExtension.class)
public class RequestInfoServiceImplementationTest {

	private MockWebServer mockWebServer;

	private CoinConfigurationProperties configurationProperties = new CoinConfigurationProperties();

	CoinInformationServiceImplementation requestInfoServiceImplementation;

	@BeforeEach
	void setUp() throws IOException {
		this.mockWebServer = new MockWebServer();
		this.mockWebServer.start();

		this.configurationProperties.setUrl(mockWebServer.url("/api/latest").toString());
		this.configurationProperties.setParamValue("access_key");
		this.configurationProperties.setParamKey("9dd409bf55953525b107328e631f70e6");
		requestInfoServiceImplementation = new CoinInformationServiceImplementation(WebClient.builder().build(),
				this.configurationProperties);
	}

	@AfterEach
	void tearDown() throws IOException {
		this.mockWebServer.shutdown();
	}

	@Test
	void contextLoads() {
		CoinInfoResponseDTO expected = new CoinInfoResponseDTO();
		mockWebClientResponse(expected);
		CoinInfoResponseDTO result = requestInfoServiceImplementation.requestCoinInformation("eur", "usd,eur").block();
		assertThat(result).usingRecursiveComparison().isEqualTo(expected);
	}

	private void mockWebClientResponse(CoinInfoResponseDTO response) {
		MockResponse mockResponse = new MockResponse()
				.addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.setBody(Util.mapObject(response));
		mockWebServer.enqueue(mockResponse);
	}

}
