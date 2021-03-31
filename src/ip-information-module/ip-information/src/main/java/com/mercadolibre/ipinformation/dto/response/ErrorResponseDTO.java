package com.mercadolibre.ipinformation.dto.response;

public class ErrorResponseDTO {

	private int errorCode;
	private String errorDescription;

	public ErrorResponseDTO(String errorDescription, int errorCode) {
		this.errorDescription = errorDescription;
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

}
