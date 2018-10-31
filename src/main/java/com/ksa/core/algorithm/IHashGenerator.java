package com.ksa.core.algorithm;

import java.security.NoSuchAlgorithmException;

/**
 * 
 * IHashGenerator.java Class is a generic class to for encryption algorithm which needs to be implemented as per needs.
 * 
 * @version 1.0
 * @author Akhil Bhatia
 * @since Feb 28, 2017
 */
public interface IHashGenerator {

	/**
	 * encrypt method is the method which will have specific algorithm to encrypt the input given to the function.
	 * 
	 * @param request
	 * @return IHashResponse
	 * @throws NoSuchAlgorithmException
	 * @since Feb 28, 2017
	 */
	IHashResponse generateHash(IHashRequest request) throws NoSuchAlgorithmException;

}
