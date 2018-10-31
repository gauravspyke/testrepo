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
import com.ksa.core.customSerilizers.CustomGenericSerializer;

/**
 * TestCustomGenericSerializer.java Class is a test class for {@link CustomGenericSerializer}
 * 
 * @version 1.0
 * @author Manoj Singh
 * @since Apr 10, 2017 3:33:06 PM
 */
public class TestCustomGenericSerializer {
	@InjectMocks
	CustomGenericSerializer<Integer> genericSerializer;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * testSerialize method is used to perform positive test for Serialize method.
	 * 
	 * @throws JsonProcessingException
	 * @throws IOException
	 * @since Apr 10, 2017 3:39:27 PM
	 */
	@Test
	public void testSerialize() throws JsonProcessingException, IOException {
		Writer jsonWriter = new StringWriter();
		JsonGenerator jsonGenerator = new JsonFactory().createGenerator(jsonWriter);
		SerializerProvider serializerProvider = new ObjectMapper().getSerializerProvider();
		genericSerializer.serialize(new Integer(12), jsonGenerator, serializerProvider);
		jsonGenerator.flush();
		Assert.assertEquals(jsonWriter.toString(), "{\"$\":12}");

	}
}
