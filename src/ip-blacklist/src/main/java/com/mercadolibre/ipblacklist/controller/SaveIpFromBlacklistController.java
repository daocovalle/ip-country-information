package com.mercadolibre.ipblacklist.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.ipblacklist.dto.request.IPBlacklistRequestDTO;
import com.mercadolibre.ipblacklist.dto.response.BlackListResponseDTO;
import com.mercadolibre.ipblacklist.service.SaveIpBlackListService;
import com.mercadolibre.ipblacklist.util.Utils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
public class SaveIpFromBlacklistController {

	@Autowired
	SaveIpBlackListService saveIpBlackListService;

	Logger logger = LoggerFactory.getLogger(SaveIpFromBlacklistController.class);

	@ApiOperation(value = "Save an IP to add it to Blacklist Restriction", produces = MediaType.APPLICATION_JSON_VALUE, response = BlackListResponseDTO.class)
	@ApiResponse(code = 200, message = "OK")
	@PostMapping(value = "/save")
	public ResponseEntity<BlackListResponseDTO> saveIp(@RequestBody IPBlacklistRequestDTO ipBlackList) {
		logger.info(Utils.mapObject(ipBlackList));
		return new ResponseEntity<>(saveIpBlackListService.saveIpInBlackList(ipBlackList.getIp()), HttpStatus.CREATED);
	}
}
