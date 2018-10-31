
package com.ksa.core.xml.parser;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/*
 * Author - Mukul Sharma
 * Date - 29/Nov/2016
 * 
 */

@Component
public class JsonConverter {

	@Autowired
	private ObjectMapper objectMapper;

	// this converts the string Json object into type<T> objects.
	public <T> T jsonToObjectParser(String content, Class<T> valueType)
			throws JsonParseException, JsonMappingException, IOException {

		return objectMapper.readValue(content, valueType);

	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public <T> String objectToJsonStringParser(Object object) throws JsonProcessingException {

		objectMapper.configure(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED, true);
		return objectMapper.writeValueAsString(object);

	}

}
