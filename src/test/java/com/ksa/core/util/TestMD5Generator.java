package com.ksa.core.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.ksa.core.algorithm.IHashRequest;
import com.ksa.core.algorithm.IHashResponse;

/**
 * TestMD5Generator.java Class contains test cases for the class MD5Generator class to test the function of generating
 * MD5 Hash.
 * 
 * @version 1.0
 * @author Akhil Bhatia
 * @since Feb 20, 2017
 */
public class TestMD5Generator {

	private MD5Generator mD5Generator = new MD5Generator();

	/**
	 * testGenerateMD5Null method to check for null parameters in the function.
	 * 
	 * @throws NoSuchAlgorithmException
	 * @since Feb 20, 2017
	 */
	@Test
	public void testEncyptNull() throws NoSuchAlgorithmException {

		IHashResponse response = mD5Generator.generateHash(null);
		assertNull(response);

	}

	/**
	 * testGenerateMD5NotNull method to verify whether generated hash code is correct or not.
	 * 
	 * @throws NoSuchAlgorithmException
	 * @since Feb 28, 2017
	 */
	@Test
	public void testEncryptNotNull() throws NoSuchAlgorithmException {

		IHashRequest request = new MD5HashRequest();
		request.setToken("TestKey");

		IHashResponse response = mD5Generator.generateHash(request);
		assertNotNull(response);
		String md5Hash = "af84adb3a64dc4187b4e279156f476b8";

		assertEquals(response.getValue(), md5Hash);

	}
}
