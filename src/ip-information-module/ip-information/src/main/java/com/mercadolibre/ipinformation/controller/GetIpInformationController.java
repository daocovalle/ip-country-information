package com.mercadolibre.ipinformation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.ipinformation.dto.response.InformationIpResponseDTO;
import com.mercadolibre.ipinformation.service.GetIpInformationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
public class GetIpInformationController {

	@Autowired
	GetIpInformationService getIpInformationService;

	@ApiOperation(value = "Get Country Information from IP number", produces = MediaType.APPLICATION_JSON_VALUE, response = InformationIpResponseDTO.class)
	@ApiResponse(code = 200, message = "OK")
	@GetMapping(value = "/country-information")
	public ResponseEntity<InformationIpResponseDTO> prueba(@RequestParam String ip) {
		return new ResponseEntity<InformationIpResponseDTO>(getIpInformationService.getIPInformation(ip),
				HttpStatus.OK);
	}
}
