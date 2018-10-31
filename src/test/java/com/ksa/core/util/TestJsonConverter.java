package com.ksa.core.util;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ksa.core.xml.parser.JsonConverter;

/**
 * To Test JsonConverter which convert json to object and vice versa
 * 
 * @version 1.0
 * @author Mukul Sharma
 * @since Mar 22, 2017 12:43:22 PM
 */
public class TestJsonConverter {

	@Mock
	private ObjectMapper objectMapper;

	@InjectMocks
	private JsonConverter jsonConverter;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	/**
	 * To Test Json To ObjectParser
	 * TestJsonToObjectParser method
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @since Mar 23, 2017 1:39:58 PM
	 */
	@Test
	public void TestJsonToObjectParser() throws JsonParseException, JsonMappingException, IOException {
		Mockito.when(objectMapper.readValue("", TestJsonConverter.class)).thenReturn(new TestJsonConverter());
		assertNotNull(jsonConverter.getObjectMapper());
		assertNotNull(jsonConverter.jsonToObjectParser("", TestJsonConverter.class));
	}
	/**
	 * To Test Object To Json StringParser
	 * TestObjectToJsonStringParser method
	 * @throws JsonProcessingException
	 * @since Mar 23, 2017 1:40:15 PM
	 */
	@Test
	public void TestObjectToJsonStringParser() throws JsonProcessingException {
		Mockito.when(objectMapper.configure(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED, true))
				.thenReturn(new ObjectMapper());
		Mockito.when(objectMapper.writeValueAsString(null)).thenReturn("worked");
		assertNotNull(jsonConverter.objectToJsonStringParser(null));
	}

}
