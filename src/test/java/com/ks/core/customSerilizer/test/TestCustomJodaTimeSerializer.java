package com.ks.core.customSerilizer.test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ksa.core.customSerilizers.CustomJodaTimeSerializer;

/**
 * TestCustomJodaTimeSerializer.java Class is a test class for {@link CustomJodaTimeSerializer}
 * 
 * @version 1.0
 * @author Manoj Singh
 * @since Apr 10, 2017 3:41:21 PM
 */
public class TestCustomJodaTimeSerializer {

	@InjectMocks
	CustomJodaTimeSerializer customJodaTimeSerializer;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * testSerialize method is used to perform positive test for Serialize method.
	 * 
	 * @throws JsonProcessingException
	 * @throws IOException
	 * @since Apr 10, 2017 3:41:40 PM
	 */
	@Test
	public void testSerialize() throws JsonProcessingException, IOException {
		Writer jsonWriter = new StringWriter();
		JsonGenerator jsonGenerator = new JsonFactory().createGenerator(jsonWriter);
		SerializerProvider serializerProvider = new ObjectMapper().getSerializerProvider();
		DateTime dTime = new DateTime();
		customJodaTimeSerializer.serialize(dTime, jsonGenerator, serializerProvider);
		jsonGenerator.flush();
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		Assert.assertEquals(jsonWriter.toString(), "{\"$\":\"" + formatter.print(dTime) + "\"}");
	}
}
