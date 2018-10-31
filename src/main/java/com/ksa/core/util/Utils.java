package com.ksa.core.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/**
 * Utility class for all Util method Utils.java Class
 * 
 * @version 1.0
 * @author Mukul.sharma
 * @since Jan 30, 2017 5:50:44 PM
 */
@Component
public class Utils {

	private Map<String, Operator> operatorMap = new HashMap<>();

	@PostConstruct
	private void initializeMap() {
		operatorMap.put("*", new Operator() {
			@Override
			public double calculate(double leftOperand, double rightOperand) {
				return leftOperand * rightOperand;
			}

			@Override
			public boolean compare(double leftOperand, double rightOperand) {
				return false;
			}
		});
		operatorMap.put("/", new Operator() {
			@Override
			public double calculate(double leftOperand, double rightOperand) {
				return leftOperand / rightOperand;
			}

			@Override
			public boolean compare(double leftOperand, double rightOperand) {
				return false;
			}
		});
		operatorMap.put("+", new Operator() {
			@Override
			public double calculate(double leftOperand, double rightOperand) {
				return leftOperand + rightOperand;
			}

			@Override
			public boolean compare(double leftOperand, double rightOperand) {
				return false;
			}
		});
		operatorMap.put("-", new Operator() {
			@Override
			public double calculate(double leftOperand, double rightOperand) {
				return leftOperand - rightOperand;
			}

			@Override
			public boolean compare(double leftOperand, double rightOperand) {
				return false;
			}
		});
		operatorMap.put(">=", new Operator() {
			@Override
			public double calculate(double leftOperand, double rightOperand) {
				return 0;
			}

			@Override
			public boolean compare(double leftOperand, double rightOperand) {
				return leftOperand >= rightOperand;
			}
		});
		operatorMap.put(">", new Operator() {
			@Override
			public double calculate(double leftOperand, double rightOperand) {
				return 0;
			}

			@Override
			public boolean compare(double leftOperand, double rightOperand) {
				return leftOperand > rightOperand;
			}
		});
		operatorMap.put("<=", new Operator() {
			@Override
			public double calculate(double leftOperand, double rightOperand) {
				return 0;
			}

			@Override
			public boolean compare(double leftOperand, double rightOperand) {
				return leftOperand <= rightOperand;
			}
		});
		operatorMap.put("<", new Operator() {
			@Override
			public double calculate(double leftOperand, double rightOperand) {
				return 0;
			}

			@Override
			public boolean compare(double leftOperand, double rightOperand) {
				return leftOperand < rightOperand;
			}
		});
		operatorMap.put("==", new Operator() {
			@Override
			public double calculate(double leftOperand, double rightOperand) {
				return 0;
			}

			@Override
			public boolean compare(double leftOperand, double rightOperand) {
				return leftOperand == rightOperand;
			}
		});

	}

	/**
	 * This generates Random id for every call getRandomizedUUID method
	 * 
	 * @return
	 * @since Jan 30, 2017 5:53:54 PM
	 */
	public String getRandomizedUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * This method validates the format of the email id.
	 * 
	 * isValidEmailAddress method
	 * 
	 * @param emailId
	 * @return
	 * @since Feb 7, 2017
	 */
	public boolean isValidEmailAddress(String emailId) {
		if (emailId != null) {
			String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-+]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			return emailId.matches(emailRegex);
		}
		return false;
	}

	/**
	 * 
	 * This method remove period sign from resuest string
	 * 
	 * @param articleNum
	 * @return
	 * @since Feb 22, 2017 2:57:40 PM
	 */
	public String removePeriodSign(String pattern) {
		if (!pattern.contains(".")) {
			return pattern;
		}
		return pattern.replace(".", "");
	}

	/**
	 * Method used to convert Input Stream to byte Array and then to base 64
	 * String convertToBase64 method
	 * 
	 * @param uploadedInputStream
	 * @return
	 * @throws IOException
	 * @since Apr 7, 2017 12:50:35 PM
	 */
	public String convertToBase64(InputStream uploadedInputStream) throws IOException {

		String base64Image = null;

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		int nRead;
		byte[] data = new byte[2048];

		while ((nRead = uploadedInputStream.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, nRead);
		}
		buffer.flush();
		byte imageBytes[] = buffer.toByteArray();
		byte[] encodedBytes = Base64.getEncoder().encode(imageBytes);

		base64Image = new String(encodedBytes);

		return base64Image;
	}

	/**
	 * @return the operatorMap
	 */
	public Map<String, Operator> getOperatorMap() {
		return operatorMap;
	}
	
	
	/**This method takes a list of any type and a list of Attribute names. It the filters the first list and removes those 
	 * elements that have any of the given attributes as null.
	 * @param targetList
	 * @param attributes
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public <T> List<T> removeNullElements(List<T> targetList, List<String>attributes) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		List<T> responseList = new ArrayList<>();
		for(T t : targetList){
			boolean allAttributesAvailable = true;
			for(String attribute : attributes){
				Field field;
				field = t.getClass().getDeclaredField(attribute);
				field.setAccessible(true);
				Object value = field.get(t);
				if(value == null){
					allAttributesAvailable = false;
					break;
				}
			}
			if(allAttributesAvailable){
				responseList.add(t);
			}
		}
		return responseList;
	}
	

}
