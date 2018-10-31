package com.ksa.core.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ksa.core.util.TestJSONUtility;
import com.ksa.core.util.TestJsonConverter;
import com.ksa.core.util.TestMD5Generator;
import com.ksa.core.util.TestUtils;

/**
 * AllTestsCore.java Class
 * 
 * @version 1.0
 * @author Daksh Verma
 * @description Test Suite for Core project
 */
@RunWith(Suite.class)
@SuiteClasses({ TestJsonConverter.class, TestJSONUtility.class, TestMD5Generator.class, TestUtils.class })
public class CoreTestSuite {

}
