package com.ksa.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.Charsets;
import org.springframework.stereotype.Component;

import com.ksa.core.algorithm.IHashRequest;
import com.ksa.core.algorithm.IHashResponse;
import com.ksa.core.algorithm.IHashGenerator;

/**
 * MD5Generator.java Class is the utility class for generating MD5 hash for the input provided. The MD5 algorithm is a
 * widely used hash function producing a 128-bit hash value.
 * 
 * @see java.security.MessageDigest
 * 
 * @version 1.0
 * @author Akhil Bhatia
 * @since Feb 24, 2017
 */
@Component
public class MD5Generator implements IHashGenerator {

	/**
	 * encrypt method takes input as String and returns MD5 hash as string
	 * 
	 * @param request
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @since Feb 24, 2017
	 */
	public IHashResponse generateHash(IHashRequest request) throws NoSuchAlgorithmException {

		if (request == null) {
			return null;
		}
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");

		messageDigest.update(request.getToken().getBytes(Charsets.UTF_8));

		byte byteData[] = messageDigest.digest();

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < byteData.length; i++) {
			// Converts the byte data from digest into Hex and append it into string
			stringBuilder.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		IHashResponse response = new MD5HashResponse(stringBuilder.toString());
		return response;
	}

}
