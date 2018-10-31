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
import com.ksa.core.customSerilizers.CustomLongSerializer;

/**
 * TestCustomLongSerializer.java Class is a test class for {@link CustomLongSerializer}
 * @version 1.0
 * @author Manoj Singh
 * @since Apr 20, 2017 5:19:54 PM
 */
public class TestCustomLongSerializer {

	@InjectMocks
	CustomLongSerializer customLongSerializer;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * testSerialize method is used to perform positive test for Serialize method.
	 * @throws JsonProcessingException
	 * @throws IOException
	 * @since Apr 20, 2017 5:19:52 PM
	 */
	@Test
	public void testSerialize() throws JsonProcessingException, IOException {
		Writer jsonWriter = new StringWriter();
		JsonGenerator jsonGenerator = new JsonFactory().createGenerator(jsonWriter);
		SerializerProvider serializerProvider = new ObjectMapper().getSerializerProvider();
		customLongSerializer.serialize(new Long(12345), jsonGenerator, serializerProvider);
		jsonGenerator.flush();
		Assert.assertEquals(jsonWriter.toString(), "{\"$\":12345}");

	}

	

}
