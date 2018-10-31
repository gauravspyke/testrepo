package com.ksa.core.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import org.springframework.stereotype.Component;

/**
 * Utility class for all ENcoding related utilities.
 * Utils.java Class
 * @version 1.0
 * @author Amrita Upreti
 * @since Apr 13, 2017 10:50:44 AM
 */
@Component
public class EncoderUtility {

	/**Method used to convert Input Stream to byte Array and then to base 64 String
	 * convertToBase64 method
	 * @param uploadedInputStream
	 * @return
	 * @throws IOException 
	 * @since Apr 7, 2017 12:50:35 PM
	 */
	public String convertToBase64(InputStream uploadedInputStream) throws IOException {

		String base64Image = null;

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		int nRead;
		byte[] data = new byte[2048];

		while ((nRead = uploadedInputStream.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, nRead);
		}
		buffer.flush();
		byte imageBytes[] = buffer.toByteArray();
		byte[] encodedBytes = Base64.getEncoder().encode(imageBytes);

		base64Image = new String(encodedBytes);
		
		return base64Image;

	}

	
}
