package com.mercadolibre.ipinformation.service.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.blacklist.service.GetIpFromBlackListService;
import com.mercadolibre.coininformation.service.CoinInformationService;
import com.mercadolibre.countryinformation.service.CountryService;
import com.mercadolibre.ipgeolocation.service.GeolocationInfoService;
import com.mercadolibre.ipinformation.dto.response.InformationIpResponseDTO;
import com.mercadolibre.ipinformation.exeption.ServiceException;
import com.mercadolibre.ipinformation.util.BuildObjects;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
class GetIpInformationServiceImplementationTest {

	@Mock
	CountryService countryService;

	@Mock
	CoinInformationService coinInformationService;

	@Mock
	GeolocationInfoService geolocationService;

	@Mock
	GetIpFromBlackListService getIpFromBlackListService;

	@InjectMocks
	GetIpInformationServiceImplementation getIpInformationServiceImplementation;

	@Test
	void validateNotBlackListIPResponseSuccess() {

		when(countryService.requestCountryInformation(BuildObjects.ISO_CODE3))
				.thenReturn(Mono.just(BuildObjects.buildCountryResponse()));

		when(coinInformationService.requestCoinInformation(BuildObjects.CURRENCY_EUR, BuildObjects.SYMBOLS))
				.thenReturn(Mono.just(BuildObjects.buildCoinInfoResponse()));

		when(geolocationService.requestGeolocationInformation(BuildObjects.TEST_IP))
				.thenReturn(Mono.just(BuildObjects.buildGeolocationInfoResponse()));

		when(getIpFromBlackListService.retrieveIpFromBlacklist(BuildObjects.TEST_IP))
				.thenReturn(Mono.just(BuildObjects.buildNotFoundBlackListResponse()));

		InformationIpResponseDTO countryInformationByIpResult = getIpInformationServiceImplementation
				.getIPInformation(BuildObjects.TEST_IP);

		System.out.println(countryInformationByIpResult.getCountryName());
		assertEquals(countryInformationByIpResult.getCountryName(), BuildObjects.COUNTRY_NAME);

	}

	@Test
	void validateBlackListIPResponseSuccess() {
		when(getIpFromBlackListService.retrieveIpFromBlacklist(BuildObjects.TEST_IP))
				.thenReturn(Mono.just(BuildObjects.builFoundBlackListResponse()));

		assertThrows(ServiceException.class,
				() -> getIpInformationServiceImplementation.getIPInformation(BuildObjects.TEST_IP));
	}

}
