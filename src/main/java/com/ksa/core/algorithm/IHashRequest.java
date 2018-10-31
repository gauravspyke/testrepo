package com.ksa.core.algorithm;

/**
 * 
 * IHashRequest.java is the interface for the request required for the encryption function.
 * 
 * @version 1.0
 * @author Akhil Bhatia
 * @since Feb 28, 2017
 */
public interface IHashRequest {

	/**
	 * setToken method sets the String value for the parameter passed.
	 * 
	 * @param encryptTag
	 * @since Feb 28, 2017
	 */
	public void setToken(String encryptTag);

	/**
	 * getToken method returns the value of implementation class variable
	 * 
	 * @return
	 * @since Feb 28, 2017
	 */
	public String getToken();

}
