package com.ksa.core.exception;

public class InvalidUserException extends CoreException {

	private static final long serialVersionUID = 1L;

	public InvalidUserException(Exception e) {
		super(e);
	}

	public InvalidUserException() {
		//default constructor
	}

	public InvalidUserException(String message) {
		super.setExceptionMessage(message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
