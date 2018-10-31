package com.ksa.core.soapclient.services;

import com.ksa.core.bo.RequestObject;

/**
 * Interface that is to be implemented by any bean that wishes to create 
 * and send HTTP request and returns back the response.
 * @author GUR39165
 *
 */
public interface IRestClient {
	
	/**
	 * would create the HTTP url, create connection and retrieves the response
	 * from the input stream.
	 * @param request object for any HTTP request.
	 * @return StringBuffer object which contains the response of the HTTP request 
	 * @throws Exception if request fails.
	 */
	StringBuffer getRestResponse(RequestObject request) throws Exception;
}
