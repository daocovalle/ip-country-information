package com.mercadolibre.ipblacklist.excepction;

public class BlackListException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -872605492442605916L;
	private final int errorCode;
	private final String response;

	public BlackListException(int errorCode, String response) {
		super();
		this.errorCode = errorCode;
		this.response = response;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getResponse() {
		return response;
	}

}
