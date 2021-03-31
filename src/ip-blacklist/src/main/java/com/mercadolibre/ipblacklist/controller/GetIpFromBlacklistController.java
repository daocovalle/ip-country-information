package com.mercadolibre.ipblacklist.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.ipblacklist.dto.response.BlackListResponseDTO;
import com.mercadolibre.ipblacklist.service.RetrieveIpFromBlackListService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
public class GetIpFromBlacklistController {

	@Autowired
	RetrieveIpFromBlackListService getIpFromBlackListService;

	Logger logger = LoggerFactory.getLogger(GetIpFromBlacklistController.class);

	@ApiOperation(value = "Return the result of Blacklist IP Restriction", produces = MediaType.APPLICATION_JSON_VALUE, response = BlackListResponseDTO.class)
	@ApiResponse(code = 200, message = "OK")
	@GetMapping(value = "/retrieve")
	public ResponseEntity<BlackListResponseDTO> retriveIp(@RequestParam String ip) {
		return new ResponseEntity<BlackListResponseDTO>(getIpFromBlackListService.retrieveIpFromBlacklist(ip),
				HttpStatus.OK);
	}

}
