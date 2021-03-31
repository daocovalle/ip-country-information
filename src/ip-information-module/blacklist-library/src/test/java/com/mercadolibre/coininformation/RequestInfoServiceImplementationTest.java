package com.mercadolibre.coininformation;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RequestInfoServiceImplementationTest {
//
//	private MockWebServer mockWebServer;
//
//	private CoinConfigurationProperties configurationProperties = new CoinConfigurationProperties();
//
//	CoinInformationServiceImplementation requestInfoServiceImplementation;
//
//	@BeforeEach
//	void setUp() throws IOException {
//		this.mockWebServer = new MockWebServer();
//		this.mockWebServer.start();
//
//		this.configurationProperties.setUrl(mockWebServer.url("/api/latest").toString());
//		this.configurationProperties.setParamValue("access_key");
//		this.configurationProperties.setParamKey("9dd409bf55953525b107328e631f70e6");
//		requestInfoServiceImplementation = new CoinInformationServiceImplementation(WebClient.builder().build(),
//				this.configurationProperties);
//	}
//
//	@AfterEach
//	void tearDown() throws IOException {
//		this.mockWebServer.shutdown();
//	}
//
//	@Test
//	void contextLoads() {
//		CoinInfoResponseDTO expected = new CoinInfoResponseDTO();
//		mockWebClientResponse(expected);
//		CoinInfoResponseDTO result = requestInfoServiceImplementation.requestCoinInformation("eur", "usd,eur").block();
//		assertThat(result).usingRecursiveComparison().isEqualTo(expected);
//	}
//
//	private void mockWebClientResponse(CoinInfoResponseDTO response) {
//		MockResponse mockResponse = new MockResponse()
//				.addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//				.setBody(Util.mapObject(response));
//		mockWebServer.enqueue(mockResponse);
//	}

}
