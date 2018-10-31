package com.ksa.core.util;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;
import org.w3c.dom.Document;

/**
 * 
 * TestXSLUtility.java Class is a test class for XSLUtility class functionalities
 * @version 1.0
 * @author Amrita Upreti
 * @since Apr 20, 2017 9:49:09 AM
 */
public class TestXSLUtility {

	@InjectMocks
	private XSLUtility xslUtility;
	
	private final static String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"+
            "<Emp id=\"1\"><name>Pankaj</name><age>25</age>\n"+
            "<role>Developer</role><gen>Male</gen></Emp>";
	
	
	/**This method returns a dummy Retailcomm XML String.
	 * @return
	 */
	private String getDummyString() {
		String dummyData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
		"<ns:RetailItemComm	\nxmlns:ns=\"ikea.com/cem/iows/RetailItemCommunicationService/2.0/\""+
		  "\nxmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"+
		  "\n<ItemNo>19131261</ItemNo>"+
		  "\n<ItemNoGlobal>19131261 </ItemNoGlobal>"+
		  "\n<ItemType>SPR </ItemType>"+
		  "\n<ProductName>MALM </ProductName>"+
		  "\n<ProductTypeName>Bed frame, high </ProductTypeName>"+
		  "\n<ValidDesignText>brown stained ash veneer, Lur&#246;y 	  </ValidDesignText>"+
		  "\n<OnlineSellable>true </OnlineSellable>"+	    
		  "\n<BreathTakingItem>false </BreathTakingItem>"+
		  "\n<ItemUnitCode>PIECES   </ItemUnitCode>"+
		  "\n<ItemNumberOfPackages>5 </ItemNumberOfPackages>"+
		  "\n<AssemblyCode>Y </AssemblyCode>"+
		  "\n</ns:RetailItemComm>";

		return dummyData;
	}
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * This method tests the convertString to Document utility with null input
	 */
	@Test
	public void convertStringToDocumentNull(){
		Document document = xslUtility.convertStringToDocument(null);
		Assert.isNull(document);
	}
	
	/**
	 * This method tests the convertString to Document utility with valid input
	 */
	@Test
	public void convertStringToDocumentSuccess(){
		Document document = xslUtility.convertStringToDocument(xmlStr);
		Assert.notNull(document);
 	}
	
	/**
	 * This method tests the convertDocument to String utility with null input
	 */
	@Test
	public void convertDocumentToStringNull(){
			String response = xslUtility.convertDocumentToString(null);
			Assert.notNull(response);
		}
	
	/**
	 * This method tests the convertDocument to String utility with valid input
	 */
	@Test
	public void convertDocumentToStringSuccess(){
		Document document = xslUtility.convertStringToDocument(xmlStr);
		Assert.notNull(document);
		String response = xslUtility.convertDocumentToString(document);
		Assert.notNull(response);
	}
		
	/**
	 * This method tests the removeAllAttributes utility with Null input
	 * @throws XPathExpressionException
	 */
	@Test (expected = XPathExpressionException.class)
	public void removeAllAttributesNull() throws XPathExpressionException{
		Document document = xslUtility.removeAllAttributes(null);
	}
	
	/**This method tests the removeAllAttributes utility with Valid input
	 * @throws XPathExpressionException
	 */
	@Test 
	public void removeAllAttributesSuccess() throws XPathExpressionException{
		Document document = xslUtility.convertStringToDocument(xmlStr);
		Assert.notNull(document);
		Document documentUpdated = xslUtility.removeAllAttributes(document);
		Assert.notNull(documentUpdated);
	}
	
	/**This method tests the parseXMLToJSON utility with Null input throws NullPointerException
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerException
	 */
	@Test(expected=NullPointerException.class)
	public void parseXMLToJSONNull() throws TransformerFactoryConfigurationError, TransformerException{
		JSONObject json = xslUtility.parseXMLToJSON(null, "productdetailSingle.xsl");
	}
	
	/**This method tests the parseXMLToJSON utility with valid input
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerException
	 */
	@Test
	public void parseXMLToJSONSuccess() throws TransformerFactoryConfigurationError, TransformerException{
		System.out.println(getDummyString());
		JSONObject json = xslUtility.parseXMLToJSON(getDummyString(), "productdetailSingle.xsl");
		Assert.notNull(json);
	}	
}
