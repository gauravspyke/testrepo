package com.ksa.core.exception;

public class BadRequestException extends CoreException {

	private static final long serialVersionUID = 1L;

	public BadRequestException(Exception e) {
		super(e);
	}

	public BadRequestException() {
		//default constructor
	}

	public BadRequestException(String message) {
		super.setExceptionMessage(message);
	}
	

	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
}
