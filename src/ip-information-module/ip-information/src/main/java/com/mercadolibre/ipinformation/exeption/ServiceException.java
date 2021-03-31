
package com.mercadolibre.ipinformation.exeption;

public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -872605492442605916L;
	private final int errorCode;
	private final String errorMessage;

	public ServiceException(String errorMessage, int errorCode) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
