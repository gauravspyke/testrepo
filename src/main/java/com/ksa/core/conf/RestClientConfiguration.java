package com.ksa.core.conf;

import java.util.Map;

import com.ksa.core.rest.AsyncServiceTask;
import com.ksa.core.rest.AsyncServiceTask.RequestMethod;

/**
 * This interface is used to provide configuration that is being used by
 * {@link AsyncServiceTask} for accessing RESTFUL APIs.
 * 
 * @version 1.0
 * @author Shashank Agarwal
 * @since Feb 9, 2017 4:45:02 PM
 */
public interface RestClientConfiguration {

	/**
	 * Provides cookie information to validate user authenticity
	 * 
	 * @return
	 * @since Feb 9, 2017 4:47:19 PM
	 */
	String getCookie();

	/**
	 * This is being used for deciding API version that could be passed in
	 * header information
	 * 
	 * @return
	 * @since Feb 9, 2017 4:48:54 PM
	 */
	int getVersion();

	/**
	 * This interface method is being used to update version that is used in api
	 * header
	 * 
	 * @param version
	 * @since Feb 9, 2017 4:49:34 PM
	 */
	void updateVersion(int version);

	/**
	 * This interface method is used to update base url header for REST client
	 * api
	 * 
	 * @param baseUrl
	 * @since Feb 9, 2017 4:50:10 PM
	 */
	void updateBaseUrl(String baseUrl);

	/**
	 * This interface method is to provide base url for accessing REST APIs
	 * 
	 * 
	 * @return
	 * @since Feb 9, 2017 4:50:45 PM
	 */
	String getBaseUrl();

	/**
	 * This interface method is being used to provide all list of headers that
	 * are used to map with an API
	 * 
	 * @return
	 * @since Feb 9, 2017 4:51:26 PM
	 */
	Map<String, String> getHeaders();

	/**
	 * This interface method is being used to provide all headers that dont have
	 * cookie in it.
	 * 
	 * @return
	 * @since Feb 9, 2017 4:52:01 PM
	 */
	Map<String, String> getUnAuthHeaders();

	/**
	 * This interface method is used to provide, when API caller wants some
	 * specific header value rather then having parsed response
	 * 
	 * @return
	 * @since Feb 9, 2017 4:52:41 PM
	 */
	String getHeaderToParseResponse();

	/**
	 * This interface method is to get{@link RequestMethod} that is used for
	 * RESTFUL api
	 * 
	 * @return
	 * @since Feb 9, 2017 4:53:22 PM
	 */
	RequestMethod getRequestMethod();

	/**
	 * This interface method is to provide list of URL parameters that will be
	 * part of REST API URL
	 * 
	 * @return
	 * @since Feb 9, 2017 4:54:00 PM
	 */
	Map<String, String> getURLParameters();

	/**
	 * This interface method is to decide that API response will come default in
	 * XML
	 * 
	 * @return
	 * @since Feb 9, 2017 4:54:29 PM
	 */
	boolean useXMLAsDefaultParser();

	/**
	 * This interface method is used to set that API response will be in XML or
	 * not
	 * 
	 * @param value
	 * @since Feb 9, 2017 4:57:09 PM
	 */
	void useXMLAsDefaultParser(boolean value);

	/**
	 * This interface method is used to set which header information is required
	 * to get from REST API Header
	 * 
	 * @param header
	 * @since Feb 9, 2017 4:57:41 PM
	 */
	void setHeaderToParseResponse(String header);

	/**
	 * This interface method is to set REST API {@link RequestMethod}
	 * 
	 * @param method
	 * @since Feb 9, 2017 4:58:08 PM
	 */
	void setRequestMethod(RequestMethod method);

	/**
	 * This interface method is used to set MAP of URL parameters
	 * 
	 * @param params
	 * @since Feb 9, 2017 4:58:37 PM
	 */
	void setURLParameters(Map<String, String> params);

	/**
	 * This interface method is used to set request body. request body that can
	 * be passed as an entity in POST/PUT/DELETE REST APIs
	 * 
	 * @return
	 * @since Feb 9, 2017 4:59:02 PM
	 */
	String getRequestBody();

	/**
	 * This interface method is used to update request body
	 * 
	 * updateRequestBody method
	 * 
	 * @param requestBody
	 * @since Feb 9, 2017 5:01:07 PM
	 */
	void updateRequestBody(String requestBody);

	/**
	 * This interface method is to check if proxy is enable or not used in
	 * {@link AsyncServiceTask} class isProxyEnabled method
	 * 
	 * @return
	 * @since Feb 9, 2017 5:04:41 PM
	 */

	boolean isProxyEnabled();

	/**
	 * This interface method is to enable or disable the proxy used in
	 * {@link AsyncServiceTask} class isProxyEnabled method
	 * 
	 * @return
	 * @since Feb 9, 2017 5:04:41 PM
	 */
	void enableProxy(boolean enable);

}
