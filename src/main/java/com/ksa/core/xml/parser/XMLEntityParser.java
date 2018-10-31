package com.ksa.core.xml.parser;

import com.ksa.core.xml.converters.JodaTimeConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;
import com.thoughtworks.xstream.io.xml.StaxDriver;

/**
 * This parser provide functionality to parse XML responses to Object form &
 * vice-Versa
 * 
 * @author GUR37729
 *
 */
public class XMLEntityParser<T> {

	private XStream xStreamParser;

	public XMLEntityParser() {
		xStreamParser = new XStream(new PureJavaReflectionProvider(), new StaxDriver());
		xStreamParser.ignoreUnknownElements();
		// added as to parse joda time & to provide output in Date format
		xStreamParser.registerConverter(new JodaTimeConverter<T>());
		// xStreamParser.registerConverter(new LongConverter());
	}

	@SuppressWarnings("unchecked")
	public T fromXML(String xmlResponse) {
		return (T) xStreamParser.fromXML(xmlResponse);
	}

	public String toXML(T obj) {
		return xStreamParser.toXML(obj);
	}

	public void processAnnotation(Class<? extends Object> toProcess) {
		xStreamParser.processAnnotations(toProcess);
	}
}
