package com.ksa.core.exception;

/**
 * 
 * @author GUR37729
 *
 */
public class ServiceClientException extends CoreException {

	private static final long serialVersionUID = 1L;

	private String serviceResponse;

	public ServiceClientException(Exception e) {
		super(e);
	}

	public ServiceClientException() {
		// default constructor
	}

	public ServiceClientException(String message) {
		super();
		setExceptionMessage(message);
	}

	/**
	 * @return the serviceResponse
	 */
	public String getServiceResponse() {
		return serviceResponse;
	}

	/**
	 * @param serviceResponse
	 *            the serviceResponse to set
	 */
	public void setServiceResponse(String serviceResponse) {
		this.serviceResponse = serviceResponse;
	}
}
