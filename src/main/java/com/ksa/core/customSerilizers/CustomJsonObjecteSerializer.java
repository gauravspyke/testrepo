package com.ksa.core.customSerilizers;

import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomJsonObjecteSerializer extends JsonSerializer<JSONObject> {

	@Override
	public void serialize(JSONObject value, JsonGenerator jgen, SerializerProvider serializers) throws IOException, JsonProcessingException {
		jgen.writeRawValue(value.toString());
	}

}
