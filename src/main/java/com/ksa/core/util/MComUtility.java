package com.ksa.core.util;

import java.math.BigDecimal;

import com.ksa.ckout.api.exception.NullValueException;

import antlr.StringUtils;

/**
 * This is utility class to to parse the data for null checks. MComUtility.java
 * Class
 * 
 * @version 1.0
 * @author Priya Jain
 * @since Jan 16, 2017
 */
public class MComUtility {

	public static String checkIfNull(Object fieldValue, String fieldName) {
		if (fieldValue == null) {
			String errorMessage = String.format(
					"Exception Occured : The Field Value for %s is null or Blank. The field Value is : %s", fieldName,
					fieldValue);
			throw new NullValueException(errorMessage);
		} else {
			return fieldValue.toString();
		}
	}

	public static boolean checkIfStringNullOrEmpty(String value) {
		if (value == null || value.isEmpty())
			return true;
		return false;
	}

	public static Integer parseIntValue(Object fieldValue, String fieldName) {
		if (fieldValue == null) {
			String errorMessage = String.format(
					"Exception Occured : The Field Value for %s is null or Blank. The field Value is : %s", fieldName,
					fieldValue);
			throw new NullValueException(errorMessage);
		} else {
			return Integer.parseInt(fieldValue.toString());
		}
	}

	public static BigDecimal parseBigDecimalValue(BigDecimal fieldValue, String fieldName) {
		if (fieldValue == null) {
			String errorMessage = String.format(
					"Exception Occured : The Field Value for %s is null or Blank. The field Value is : %s", fieldName,
					fieldValue);
			throw new NullValueException(errorMessage);
		} else {
			return fieldValue;
		}
	}

	public static String setDefaultIfNull(Object fieldValue, Object defaultValue) {
		if (fieldValue == null || fieldValue.equals("")) {
			return defaultValue.toString();
		}
		return fieldValue.toString();
	}
}
