package com.ksa.core.conf;

import java.util.HashMap;
import java.util.Map;

import com.ksa.core.rest.AsyncServiceTask.RequestMethod;

public abstract class AbstractRestClientConfiguration implements RestClientConfiguration {

	private int version;
	private String cookie;
	private RequestMethod method;
	private String baseUrl;
	private String header;
	private boolean useXMLAsDefault;
	private String requestBody;
	private Map<String, String> urlParams;
	private boolean enableProxy;

	public AbstractRestClientConfiguration() {
		urlParams = new HashMap<String, String>();
		version = 2;
	}

	public RequestMethod getMethod() {
		return method;
	}

	public String getCookie() {
		return cookie;
	}

	public boolean useXMLAsDefaultParser() {
		return useXMLAsDefault;
	}

	public RequestMethod getRequestMethod() {
		return method;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public void setRequestMethod(RequestMethod method) {
		this.method = method;
	}

	public String getHeaderToParseResponse() {
		return header;
	}

	public void setHeaderToParseResponse(String header) {
		this.header = header;
	}

	public Map<String, String> getURLParameters() {
		return urlParams;
	}

	public void setURLParameters(Map<String, String> params) {
		this.urlParams = params;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void updateBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public void useXMLAsDefaultParser(boolean value) {
		this.useXMLAsDefault = value;
	}

	public void updateVersion(int version) {
		this.version = version;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void updateRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public boolean isProxyEnabled() {
		return enableProxy;
	}

	public void enableProxy(boolean enable) {
		this.enableProxy = enable;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "AbstractRestClientConfiguration [version=" + version + ", cookie=" + cookie + ", method=" + method
				+ ", baseUrl=" + baseUrl + ", header=" + header + ", useXMLAsDefault=" + useXMLAsDefault
				+ ", requestBody=" + requestBody + ", urlParams=" + urlParams + ", enableProxy=" + enableProxy + "]";
	}
}
