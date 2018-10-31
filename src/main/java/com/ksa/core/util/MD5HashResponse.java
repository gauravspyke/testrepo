package com.ksa.core.util;

import com.ksa.core.algorithm.IHashResponse;

/**
 * MD5HashResponse.java Class is the implementation for the {@Link IHashResponse},it will contain a string which will be
 * encrypted when passed as a request.
 * 
 * @version 1.0
 * @author Akhil Bhatia
 * @since Feb 28, 2017
 */
public class MD5HashResponse implements IHashResponse {

	private String hashValue;

	public MD5HashResponse(String hashValue) {
		super();
		this.hashValue = hashValue;
	}

	/**
	 * @return the hashValue
	 */
	public String getValue() {
		return hashValue;
	}

}
