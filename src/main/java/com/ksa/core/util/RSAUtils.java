package com.ksa.core.util;

import java.util.Base64;
import javax.crypto.spec.IvParameterSpec;


import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.ksa.core.bo.CorePropertiesConstants;
import com.ksa.core.constants.responses.GenericResponseConstants;
import com.ksa.core.exception.ServiceClientException;


/**This class is the Utility class for RSA encoding and decoding.
 * @version 1.0
 * @author Amrita Upreti
 * @since Oct 05, 2017 4:05:13 PM
 *
 */
@Component
public class RSAUtils {
	
	@Autowired
	private Environment environment;
	private String RSA_KEY;
	private String AES_CBS_PKCS5Padding;
    private String INITVECTOR; // 16 bytes IV
    private String AES;
	private final String UTF8 = "UTF-8";
	
	@PostConstruct
	public void initIt() throws Exception {
		RSA_KEY = environment.getProperty(CorePropertiesConstants.MCOM_ENCRYPTION_RSA_KEY.getPropertyValue());
		AES = environment.getProperty(CorePropertiesConstants.MCOM_ENCRYPTION_AES.getPropertyValue());
		INITVECTOR = environment.getProperty(CorePropertiesConstants.MCOM_ENCRYPTION_INITVECTOR.getPropertyValue());
		AES_CBS_PKCS5Padding = environment.getProperty(CorePropertiesConstants.MCOM_ENCRYPTION_AES_CBS_PKCS5PADDING.getPropertyValue());
	}
	
    /**
     *This method encrypts the json
     * @param encryptJson
     * @return
     * @throws ServiceClientException 
     */
    public String encryptJsonToString(final String encryptJson) throws ServiceClientException {
        String encryptedText = null;
        try {
            byte[] encryptedName = encryptJsonToByte(encryptJson);
            encryptedText = new String(encryptedName, UTF8);
        } catch (Exception e) {
        	throw new ServiceClientException(GenericResponseConstants.INTERNAL_SERVER_ERROR.getResponseText());
        }
        return encryptedText;

    }
    
    /**encrypts to bytes
     * @param encryptJson
     * @return
     * @throws ServiceClientException 
     */
    public byte[] encryptJsonToByte(final String encryptValue) throws ServiceClientException {
    	byte[] encryptedName = null;
        try {
        	 // Create key and cipher
        	final SecretKeySpec aesKey = new SecretKeySpec(RSA_KEY.getBytes(), AES);
            final IvParameterSpec ivParameterSpec = new IvParameterSpec(INITVECTOR.getBytes("UTF-8"));
            final Cipher cipher = Cipher.getInstance(AES_CBS_PKCS5Padding);
            
            //Encrypt data
            cipher.init(Cipher.ENCRYPT_MODE, aesKey, ivParameterSpec);
            final byte[] inputByte = encryptValue.getBytes();
            encryptedName = Base64.getEncoder().encode(cipher.doFinal(inputByte));
            
        } catch (Exception e) {
            throw new ServiceClientException(GenericResponseConstants.INTERNAL_SERVER_ERROR.getResponseText());
        }
        return encryptedName;

    }

    /**
     * This method decrypts the input request
     * @param decryptJson
     * @return
     * @throws ServiceClientException 
     */
    public String decryptJson(String decryptValue) throws ServiceClientException {
        final byte[] inputByte = decryptValue.getBytes();
        return decryptBytes(inputByte);
    }
    
    /**
     * This method decrypts the input request
     * @param decryptJson
     * @return
     * @throws ServiceClientException 
     */
    public String decryptBytes(byte[] decryptValue) throws ServiceClientException {
        String decryptText = null;
       
        try {
            // Create key and cipher
            final SecretKeySpec aesKey = new SecretKeySpec(RSA_KEY.getBytes(), AES);
            final IvParameterSpec ivParameterSpec = new IvParameterSpec(INITVECTOR.getBytes("UTF-8"));
            final Cipher cipher = Cipher.getInstance(AES_CBS_PKCS5Padding);
            cipher.init(Cipher.DECRYPT_MODE, aesKey, ivParameterSpec);
           
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(decryptValue));
            decryptText = new String(decrypted);
        } catch (final Exception e) {
        	throw new ServiceClientException(GenericResponseConstants.INTERNAL_SERVER_ERROR.getResponseText());
        }
        return decryptText;
    }
    
}

