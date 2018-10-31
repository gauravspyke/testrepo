package com.ksa.core.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * To Test utilities methods. TestUtils.java Class
 * 
 * @version 1.0
 * @author Mukul Sharma
 * @since Mar 22, 2017 12:43:22 PM
 */
public class TestUtils {

	@InjectMocks
	private Utils utils;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * TO Test Randomized UUID method testGetRandomizedUUID method
	 * 
	 * @since Mar 22, 2017 12:43:44 PM
	 */
	@Test
	public void testGetRandomizedUUID() {
		assertNotNull(utils.getRandomizedUUID());
	}

	/**
	 * TO Test valid email address testIsValidEmailAddress method
	 * 
	 * @since Mar 22, 2017 12:44:01 PM
	 */
	@Test
	public void testIsValidEmailAddress() {
		assertNotNull(utils.isValidEmailAddress("mukul2.sharma@aricent.com"));
	}

	/**
	 * TO test valid email address while null case.
	 * testIsValidEmailAddressNegative method
	 * 
	 * @since Mar 22, 2017 12:44:14 PM
	 */
	@Test
	public void testIsValidEmailAddressNegative() {
		assertNotNull(utils.isValidEmailAddress(null));
	}
	
	/**
	 * To Test Remove Period Sign Method while (.) is in input.
	 * testRemovePeriodSign method
	 * @since Mar 22, 2017 12:44:53 PM
	 */
	@Test
	public void testRemovePeriodSign() {
		assertNotNull(utils.removePeriodSign("1203.1"));
	}
	/**
	 * To Test Remove Period Sign Method while (.) is not in input.
	 * testRemovePeriodSign method
	 * @since Mar 22, 2017 12:44:53 PM
	 */
	@Test
	public void testRemovePeriodSignNegative() {
		assertNotNull(utils.removePeriodSign("12031"));
	}
}
