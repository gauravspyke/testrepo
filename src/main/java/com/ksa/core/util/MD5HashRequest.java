package com.ksa.core.util;

import com.ksa.core.algorithm.IHashRequest;

/**
 * MD5HashRequest.java Class is the implementation for the {@Link IHashRequest},it will contain a string which is to be
 * encrypted when it will be passed as a request.
 * 
 * @version 1.0
 * @author Akhil Bhatia
 * @since Feb 28, 2017
 */
public class MD5HashRequest implements IHashRequest {

	private String tokenToBeHashed;

	/**
	 * @param tokenToBeHashed
	 *            the tokenToBeHashed to set
	 */
	public void setToken(String tokenToBeHashed) {
		this.tokenToBeHashed = tokenToBeHashed;

	}

	/**
	 * @return the tokenToBeHashed
	 */

	public String getToken() {
		return this.tokenToBeHashed;
	}

}
