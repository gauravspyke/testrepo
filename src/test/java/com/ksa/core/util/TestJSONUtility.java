package com.ksa.core.util;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.ksa.core.util.testobjects.TestJSONobject;

/**
 * 
 * TestJSONUtility.java Class is a test class for JSONUtility class functionalities
 * @version 1.0
 * @author Harsh Lal
 * @since Feb 14, 2017 3:49:09 PM
 */
public class TestJSONUtility {
	
	@InjectMocks
	JSONUtility jsonUtility;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * 
	 * getDummyTestJSONobject method is used to provide dummy TestJSONobject POJO for testing.
	 * @return
	 * @since Feb 14, 2017 3:49:39 PM
	 */
	private TestJSONobject getDummyTestJSONobject()
	{
		TestJSONobject testJSONRequest = new TestJSONobject();
		testJSONRequest.setAccess_code("access_code");
		testJSONRequest.setAmount("amount");
		testJSONRequest.setAuthorization_code("authorization_code");
		testJSONRequest.setCard_number("card_number");
		testJSONRequest.setCommand("command");
		testJSONRequest.setCurrency("currency");
		testJSONRequest.setCustomer_email("customer_email");
		testJSONRequest.setCustomer_ip("customer_ip");
		testJSONRequest.setCustomer_name("customer_name");
		testJSONRequest.setEci("eci");
		testJSONRequest.setExpiry_date("expiry_date");
		testJSONRequest.setFort_id("fort_id");
		testJSONRequest.setLanguage("language");
		testJSONRequest.setMerchant_identifier("merchant_identifier");
		testJSONRequest.setMerchant_reference("merchant_reference");
		testJSONRequest.setOrder_description("order_description");
		testJSONRequest.setPayment_option("payment_option");
		testJSONRequest.setRemember_me("remember_me");
		testJSONRequest.setResp3ds_url("resp3ds_url");
		testJSONRequest.setResponse_code("response_code");
		testJSONRequest.setResponse_message("response_message");
		testJSONRequest.setSadad_olp("sadad_olp");
		testJSONRequest.setSignature("signature");
		testJSONRequest.setStatus("status");
		testJSONRequest.setToken_name("token_name");
		return(testJSONRequest);
	}
	
	/**
	 * 
	 * convertJsonToStringNull method is used to perform null check for convertJsonToString method.
	 * @throws JsonProcessingException 
	 * @since Feb 14, 2017 3:50:23 PM
	 */
	@Test
	public void convertJsonToStringNull() throws JsonProcessingException
	{
		String response  = jsonUtility.convertJsonToString(null);
		Assert.isNull(response);
	}
	
	/**
	 * 
	 * convertJsonToStringNotNull method is used to perform not-null (positive) check for convertJsonToString method.
	 * @throws JsonProcessingException 
	 * @since Feb 14, 2017 3:50:58 PM
	 */
	@Test
	public void convertJsonToStringNotNull() throws JsonProcessingException
	{
		TestJSONobject testJSONRequest = getDummyTestJSONobject();
		
		String response  = jsonUtility.convertJsonToString(testJSONRequest);
		Assert.notNull(response);
	}
	
	/**
	 * 
	 * convertStringToJsonNotNull method is used to perform not-null (positive) check for convertStringToJson method.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @since Feb 14, 2017 3:51:41 PM
	 */
	@Test
	public void convertStringToJsonNotNull() throws JsonParseException, JsonMappingException, IOException
	{
		TestJSONobject testJSONobject = null;
		testJSONobject = jsonUtility.convertStringToJson("{\"3ds_url\":\"hello\"}", TestJSONobject.class);
		Assert.isTrue(testJSONobject.getResp3ds_url().equals("hello"));
	}
	
	/**
	 * 
	 * convertStringToJsonNullString method is used to perform null check for convertStringToJson method.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @since Feb 14, 2017 3:52:19 PM
	 */
	@Test
	public void convertStringToJsonNullString() throws JsonParseException, JsonMappingException, IOException
	{
		TestJSONobject testJSONobject = null;
		testJSONobject = jsonUtility.convertStringToJson(null, TestJSONobject.class);
		Assert.isNull(testJSONobject);
	}
	
	/**
	 * 
	 * convertStringToJsonNullClass method is used to perform null check for convertStringToJson method.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @throws Exception
	 * @since Feb 14, 2017 3:52:54 PM
	 */
	@Test(expected=IllegalArgumentException.class)
	public void convertStringToJsonNullClass() throws JsonParseException, JsonMappingException, IOException 
	{
		TestJSONobject testJSONobject = jsonUtility.convertStringToJson("{\"3ds_url\":\"hello\"}", null);
		Assert.isNull(testJSONobject);
	}

}
