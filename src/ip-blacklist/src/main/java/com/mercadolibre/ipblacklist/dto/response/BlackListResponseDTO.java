package com.mercadolibre.ipblacklist.dto.response;

public class BlackListResponseDTO {

	private Integer statusCode;

	private String message;

	public BlackListResponseDTO(Integer statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
