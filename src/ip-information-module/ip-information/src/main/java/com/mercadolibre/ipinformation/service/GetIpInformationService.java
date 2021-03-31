package com.mercadolibre.ipinformation.service;

import com.mercadolibre.ipinformation.dto.response.InformationIpResponseDTO;

public interface GetIpInformationService {
	InformationIpResponseDTO getIPInformation(String ip);
}
