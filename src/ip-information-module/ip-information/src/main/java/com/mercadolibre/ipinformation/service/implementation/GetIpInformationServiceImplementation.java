package com.mercadolibre.ipinformation.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.mercadolibre.blacklist.dto.response.BlackListResponseDTO;
import com.mercadolibre.blacklist.service.GetIpFromBlackListService;
import com.mercadolibre.coininformation.dto.response.CoinInfoResponseDTO;
import com.mercadolibre.coininformation.service.CoinInformationService;
import com.mercadolibre.countryinformation.dto.response.CountryResponseDTO;
import com.mercadolibre.countryinformation.service.CountryService;
import com.mercadolibre.ipgeolocation.dto.response.GeolocationInfoResponseDTO;
import com.mercadolibre.ipgeolocation.service.GeolocationInfoService;
import com.mercadolibre.ipinformation.dto.response.CoinDTO;
import com.mercadolibre.ipinformation.dto.response.InformationIpResponseDTO;
import com.mercadolibre.ipinformation.exeption.ServiceException;
import com.mercadolibre.ipinformation.service.GetIpInformationService;
import com.mercadolibre.ipinformation.util.Constants;
import com.mercadolibre.ipinformation.util.Utils;

@Service
public class GetIpInformationServiceImplementation implements GetIpInformationService {

	@Autowired
	CountryService countryService;

	@Autowired
	CoinInformationService requestIPInformationService;

	@Autowired
	GeolocationInfoService geolocationService;

	@Autowired
	GetIpFromBlackListService getIpFromBlackListService;

	Logger logger = LoggerFactory.getLogger(GetIpInformationServiceImplementation.class);

	@Override
	public InformationIpResponseDTO getIPInformation(String ip) {

		isIpInBlackList(ip);

		GeolocationInfoResponseDTO geolocationIp;
		logger.info("Calling geolocation Information");
		try {
			geolocationIp = geolocationService.requestGeolocationInformation(ip).block();
			logger.info(Utils.mapObject(geolocationIp));

			logger.info("Calling country Information");
			CountryResponseDTO infoCountry = countryService.requestCountryInformation(geolocationIp.countryCode3)
					.block();
			logger.info(Utils.mapObject(infoCountry));

			logger.info("Calling coin Information");

			List<CoinDTO> coinList = infoCountry.getCurrencies().stream().map((currency) -> {
				CoinInfoResponseDTO coinInfo = requestIPInformationService
						.requestCoinInformation(currency.getCode(), "usd,eur").block();

				logger.info(Utils.mapObject(coinInfo));

				logger.info("Transaction result success == " + coinInfo.getSuccess());

				if (Boolean.FALSE.equals(coinInfo.getSuccess())) {
					throw new ServiceException(coinInfo.getError().getType(), coinInfo.getError().getCode());
				}
				return (CoinInfoResponseDTO) coinInfo;
			}).map((currecy) -> {
				CoinDTO coinDTO = new CoinDTO();
				coinDTO.setCountryCode(currecy.getBase());
				coinDTO.setCoinTransformation(currecy.getRates());
				return coinDTO;
			}).collect(Collectors.toList());

			InformationIpResponseDTO informationIpResponseDTO = new InformationIpResponseDTO();
			informationIpResponseDTO.setCountryName(infoCountry.getName());
			informationIpResponseDTO.setIsoCode(infoCountry.getAlpha3Code());
			informationIpResponseDTO.setCoins(coinList);

			return informationIpResponseDTO;
		} catch (WebClientResponseException e) {
			throw new ServiceException(e.getLocalizedMessage(), e.getRawStatusCode());
		}
	}

	private void isIpInBlackList(String ip) {
		BlackListResponseDTO result = getIpFromBlackListService.retrieveIpFromBlacklist(ip).block();
		logger.info(Utils.mapObject(result));
		if (result == null || result.getStatusCode() == 0)
			throw new ServiceException(Constants.MESSAGE_CONSTRAINT_IP, Constants.CODE_CONSTRAINT_IP);
	}
}
