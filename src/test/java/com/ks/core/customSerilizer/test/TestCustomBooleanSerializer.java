package com.ks.core.customSerilizer.test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

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
import com.ksa.core.customSerilizers.CustomBooleanSerializer;

/**
 * TestCustomBooleanSerializer.java Class is a test class for {@link CustomBooleanSerializer}
 * @version 1.0
 * @author Manoj Singh
 * @since Apr 10, 2017 3:31:49 PM
 */
public class TestCustomBooleanSerializer {

	@InjectMocks
	CustomBooleanSerializer customBooleanSerializer;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * testSerialize method is used to perform positive test for Serialize method.
	 * 
	 * @throws JsonProcessingException
	 * @throws IOException
	 * @since Apr 10, 2017 3:31:07 PM
	 */
	@Test
	public void testSerialize() throws JsonProcessingException, IOException {
		Writer jsonWriter = new StringWriter();
		JsonGenerator jsonGenerator = new JsonFactory().createGenerator(jsonWriter);
		SerializerProvider serializerProvider = new ObjectMapper().getSerializerProvider();
		customBooleanSerializer.serialize(true, jsonGenerator, serializerProvider);
		jsonGenerator.flush();
		Assert.assertEquals(jsonWriter.toString(), "{\"$\":true}");

	}

}
