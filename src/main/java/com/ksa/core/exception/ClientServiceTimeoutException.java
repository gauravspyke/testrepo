package com.ksa.core.exception;

/**
 * 
 * @author GUR37729
 *
 */
public class ClientServiceTimeoutException extends ServiceClientException {

	private static final long serialVersionUID = 1L;

	public ClientServiceTimeoutException() {
		//default constructor
	}

	public ClientServiceTimeoutException(Exception e) {
		super(e);
	}

	@Override
	public String getMessage() {
		if (super.getMessage() == null || super.getMessage().equals(""))
			return "Unable to connect to IPS Server!";
		else
			return super.getMessage();
	}
}
