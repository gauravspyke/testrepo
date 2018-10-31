package com.ksa.core.xml.converters;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class JodaTimeConverter<T> implements Converter {

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class type) {
		return (type != null) && DateTime.class.getPackage().equals(type.getPackage());
	}

	public void marshal(final Object source, final HierarchicalStreamWriter writer, final MarshallingContext context) {
		writer.setValue(source.toString());
	}

	public Object unmarshal(final HierarchicalStreamReader reader, final UnmarshallingContext context) {
		try {
			// final Class requiredType = context.getRequiredType();
			// final Constructor constructor =
			// requiredType.getConstructor(Object.class);
			DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
			return formatter.parseDateTime(reader.getValue());
		} catch (final Exception e) {
			throw new RuntimeException(
					String.format("Exception while deserializing a Joda Time object: %s", context.getRequiredType().getSimpleName()), e);
		}
	}

}
