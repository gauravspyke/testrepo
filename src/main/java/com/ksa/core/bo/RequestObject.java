package com.ksa.core.bo;

import java.util.HashMap;
import java.util.Map;

/**
 * Request Object for a REST API
 * @author GUR39165
 *
 */
public class RequestObject {
	
	// ~ Instance field 
	//==================================================================================================
	
	private String URL;
	private Map<String, String> map;
	
	/**
	 * Create the instance of the request object.
	 */
	public RequestObject() {
		this.map=new HashMap<String,String>();
	}
	
	// ~ Getters and setters
	//==================================================================================================
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	
	public Map<String, String> getMap() {
		return map;
	}
	
	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	// ~ Methods 
	//==================================================================================================
	public final void addHeaders(String key,String value){
		map.put(key, value);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "RequestObject [URL=" + URL + ", map=" + map + "]";
	}
}
