package com.cresloga.inventory.household.householdinventory.exception;

public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3092583020651295617L;
	
	private String code;
	private String errorMessage;
	
	public ServiceException() {
		
	}
	
	public ServiceException(String code, Throwable t) {
		super(t);
		this.code = code;
		this.errorMessage = t.getMessage();
	}
	
	public ServiceException(String code, String errorMessage, Throwable t) {
		super(t);
		this.code = code;
		this.errorMessage = errorMessage;
	}
	
	public ServiceException(String code, String errorMessage) {
		this.code = code;
		this.errorMessage = errorMessage;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
