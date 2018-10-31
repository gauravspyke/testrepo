package com.ksa.core.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.google.gson.JsonParser;

/**This is a utility class for XSL related utilities.
 * XSLUtility.java Class
 * @version 1.0
 * @author Amrita Upreti
 * @since Jan 24, 2017
 */
@Component
public class XSLUtility {
	
	/**
	 * This Json Parser is used to parse the String JSON 
	 * such that it can converted to JSONObject
	 */
	private JsonParser jsonParser = new JsonParser();

	/**
	 * convertStringToDocument method Converts String to Document
	 * @param xmlStr
	 * @return Document
	 * @since Dec 14, 2016
	 */
	public Document convertStringToDocument(String xmlStr) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * convertDocumentToString method Converts Document to String
	 * @param doc
	 * @return String
	 * @since Dec 14, 2016
	 */
	public String convertDocumentToString(Document doc) {
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = tf.newTransformer();
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(doc), new StreamResult(writer));
			String output = writer.getBuffer().toString();
			return output;
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * removeAllAttributes method Strips all attributes from XML tags
	 * @param thisDoc
	 * @return Document
	 * @throws XPathExpressionException
	 * @since Dec 14, 2016
	 */
	public Document removeAllAttributes(Document thisDoc) throws XPathExpressionException {
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//*[@*]");
		NodeList result = (NodeList) expr.evaluate(thisDoc, XPathConstants.NODESET);
		for (int i = 0; i < result.getLength(); i++) {
			NamedNodeMap map = result.item(i).getAttributes();
			for (int j = 0; j < map.getLength(); j++) {
				map.removeNamedItem(map.item(j--).getNodeName());
			}
		}
		return thisDoc;
	}


	/**
	 * parseXMLToJSON method Transforms given XML to JSON style text using XSL
	 * @param inputXML
	 * @param XSLPath
	 * @return JSONObject
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerException
	 * @since Dec 14, 2016
	 */
	public JSONObject parseXMLToJSON(String inputXML, String XSLName) throws TransformerFactoryConfigurationError, TransformerException {

		Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(getClass().getResourceAsStream("/" + XSLName)));
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		transformer.transform(new StreamSource(new StringReader(inputXML)), result);
	
		String response = writer.toString();
		String jsonString = jsonParser.parse(response).toString();
		JSONObject json = new JSONObject(jsonString);
		return json;
	}

}
