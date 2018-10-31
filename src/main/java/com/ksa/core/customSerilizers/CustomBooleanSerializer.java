package com.ksa.core.customSerilizers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomBooleanSerializer extends JsonSerializer<Boolean> {

	@Override
	public void serialize(Boolean value, JsonGenerator jgen, SerializerProvider serializers) throws IOException, JsonProcessingException {
		jgen.writeStartObject();
		jgen.writeFieldName("$");
		jgen.writeObject(value);
		jgen.writeEndObject();
	}

}
