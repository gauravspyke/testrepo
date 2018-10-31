package com.ksa.core.util;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * JSONUtility.java Class contains utility functions related to JSON conversions.
 * @version 1.0
 * @author Harsh Lal
 * @since Feb 14, 2017 3:46:47 PM
 */
@Component
public class JSONUtility {
	
	/**
	 * 
	 * convertJsonToString method is used to convert Java POJO to JSON string
	 * @param obj
	 * @return
	 * @throws JsonProcessingException 
	 * @since Feb 10, 2017 3:49:57 PM
	 */
	public <T> String convertJsonToString(T obj) throws JsonProcessingException
	{
		String stringJson = null;
		if(obj!=null)
		{
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			stringJson = objectMapper.writeValueAsString(obj);
		}
		return stringJson;
	}
	
	/**
	 * 
	 * convertStringToJson method is used to map String JSON to POJOs.
	 * @param intermediateResponse
	 * @param classType
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @since Mar 9, 2017 10:13:35 AM
	 */
	public <T> T convertStringToJson(String intermediateResponse, Class<T> classType) throws JsonParseException, JsonMappingException, IOException {
		T mappedResponse = null;
		if(intermediateResponse != null)
		{
			ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			mappedResponse = objectMapper.readValue(intermediateResponse, classType);
		}
		return mappedResponse;
	}
	
}

