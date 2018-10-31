package com.ksa.core.rest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ksa.core.bo.CorePropertiesConstants;
import com.ksa.core.conf.RestClientConfiguration;
import com.ksa.core.exception.ServiceClientException;
import com.ksa.core.xml.parser.XMLEntityParser;

/**
 * An abstract class to provide rest client connectivity to access HTTP(S)
 * services. It enables to perform restful request methods like
 * GET,POST,PUT,DELETE. Default status code handling & parsing of API responses
 * based on XML & JSON is being taken care here only.
 * 
 * @version 1.0
 * @author Shashank Agarwal
 * @since Feb 11, 2017 2:39:36 PM
 */
public abstract class AsyncServiceTask<T> {

	public static final String GET_COOKIE = "Set-Cookie";
	private static final Logger logger = Logger.getLogger(AsyncServiceTask.class.getName());

	@Autowired
	private Environment environment;

	/**
	 * Supported HTTP request method for accessing {@link AsyncServiceTask}
	 * calling
	 * 
	 * @version 1.0
	 * @author Shashank Agarwal
	 * @since Feb 11, 2017 2:44:16 PM
	 */
	public enum RequestMethod {
		GET, PUT, POST, DELETE
	}

	public interface ServiceInfoNotifier {
		void notifyResponseHeaders(Map<String, String> responseHeaders);
	}

	private XMLEntityParser<T> xmlParser;
	private Map<String, String> responseHeaders;
	private ServiceInfoNotifier serviceInfo;
	private Header[] allResponseHeaders;
	
	
	/**
	 * A concrete method to perform http request & to provide parsed response
	 * based on {@link RestClientConfiguration}
	 * 
	 * @param clazz
	 * @param url
	 * @param clientConfiguration
	 * @param headers
	 * @return
	 * @throws ServiceClientException
	 * @since Feb 11, 2017 2:44:59 PM
	 */
	@SuppressWarnings("unchecked")
	public T performHttpRequest(final Class<T> clazz, final String url,
			final RestClientConfiguration clientConfiguration, Map<String, String> headers)
			throws ServiceClientException {
		HttpClient httpClient = null;
		HttpRequestBase baseRequest = null;
		String apiResponse = null;
		int statusCode = 0;
		try {
			httpClient = getClientConnection(url, clientConfiguration.isProxyEnabled());
			baseRequest = getHttpClient(url, clientConfiguration.getRequestMethod());

			if (headers != null) {
				for (Entry<String, String> entry : headers.entrySet()) {
					baseRequest.addHeader(entry.getKey(), entry.getValue());
				}
			}
			if (!clientConfiguration.getRequestMethod().equals(RequestMethod.GET)) {
				// checking for post body parameters
				if (clientConfiguration.getURLParameters() != null
						&& !clientConfiguration.getURLParameters().isEmpty()) {
					List<NameValuePair> postParameters = new ArrayList<>();
					for (Entry<String, String> param : clientConfiguration.getURLParameters().entrySet()) {
						postParameters.add(new BasicNameValuePair(param.getKey(), param.getValue()));
					}
					if (baseRequest instanceof HttpPost) {
						((HttpPost) baseRequest).setEntity(new UrlEncodedFormEntity(postParameters));
					} else if (baseRequest instanceof HttpPut) {
						((HttpPut) baseRequest).setEntity(new UrlEncodedFormEntity(postParameters));
					} else if (baseRequest instanceof CoreDelete) {
						((CoreDelete) baseRequest).setEntity(new UrlEncodedFormEntity(postParameters));
					}
				}
			}
			logger.info("URL : " + url);
			if (clientConfiguration.getRequestBody() != null) {
				HttpEntity entity = new ByteArrayEntity(clientConfiguration.getRequestBody().getBytes("UTF-8"));
				if (baseRequest instanceof HttpPost) {
					((HttpPost) baseRequest).setEntity(entity);
				} else if (baseRequest instanceof HttpPut) {
					((HttpPut) baseRequest).setEntity(entity);
				} else if (baseRequest instanceof CoreDelete) {
					((CoreDelete) baseRequest).setEntity(entity);
				}
			}
			HttpResponse response = httpClient.execute(baseRequest);

			statusCode = response.getStatusLine().getStatusCode();
			logger.info("Status code " + statusCode);
			// Get the response from the connection input stream
			
			HttpEntity entity = response.getEntity();
			if(entity != null){
				apiResponse = EntityUtils.toString(entity);
			}
			
			logger.info("Response from Parser: " + apiResponse);
			if (statusCode == HttpURLConnection.HTTP_OK || statusCode == HttpURLConnection.HTTP_CREATED
					|| statusCode == HttpURLConnection.HTTP_ACCEPTED
					|| statusCode == HttpURLConnection.HTTP_NO_CONTENT) {
				allResponseHeaders = response.getAllHeaders();
				// updating response headers, As of now storing only cookie
				if (responseHeaders == null) {
					responseHeaders = new HashMap<>();
				}
				responseHeaders.clear();
				for (Header header : response.getAllHeaders()) {
					if (!responseHeaders.containsKey(header.getName())) {
						Header cookieValues[] = response.getHeaders(header.getName());
						StringBuffer headerElements = new StringBuffer();
						for (Header element : cookieValues) {
							if (headerElements.length() != 0) {
								headerElements.append(',');
							}
							headerElements.append(element.getValue());
						}
						logger.info(String.format("Response Header -> %s : %s", header.getName(),
								headerElements.toString()));
						responseHeaders.put(header.getName(), headerElements.toString());
					}
				}
				if (serviceInfo != null) {
					serviceInfo.notifyResponseHeaders(responseHeaders);
				}
				if (clientConfiguration.getHeaderToParseResponse() != null
						&& !clientConfiguration.getHeaderToParseResponse().isEmpty()) {
					// indicates only header need to be parsed
					Header[] responseHeaders = response.getAllHeaders();
					for (Header header : responseHeaders) {
						if (header.getName() != null
								&& header.getName().equalsIgnoreCase(clientConfiguration.getHeaderToParseResponse())) {
							Header headerValues[] = response.getHeaders(clientConfiguration.getHeaderToParseResponse());
							StringBuffer headerVal = new StringBuffer();
							for (Header element : headerValues) {
								if (headerVal.length() != 0) {
									headerVal.append(',');
								}
								headerVal.append(element.getValue());
							}
							logger.info("Header val:: " + headerVal.toString());
							return (T) headerVal.toString();
						}
					}
				} else if (apiResponse == null || apiResponse.isEmpty()) {
					logger.info("API response is empty");
					return null;
				} else {
					if (clazz.getName().equals("java.lang.String")) {
						return (T) apiResponse.toString();
					}
					if (clientConfiguration.useXMLAsDefaultParser()) {
						xmlParser = new XMLEntityParser<>();
						xmlParser.processAnnotation(clazz);
						return xmlParser.fromXML(apiResponse);
					} else {
						return getMapper().readValue(apiResponse, clazz);
					}
				}
			} else {
				handleOtherCases(statusCode, response.getStatusLine().getReasonPhrase(), url, apiResponse);
			}
		} catch (Exception e) {
			if (e instanceof ServiceClientException) {
				throw ((ServiceClientException) e);
			} else {
				ServiceClientException ServiceClientException = new ServiceClientException(e);
				StringBuilder msg = new StringBuilder("API Exception Generated for URL : %s With Reason : %s");
				if (apiResponse == null) {
					ServiceClientException.setExceptionMessage(String.format(msg.toString(), url, e.getMessage()));
				} else {
					ServiceClientException.setExceptionMessage(String.format(
							msg.append(", service api Response: %s ").toString(), url, e.getMessage(), apiResponse));
				}

				ServiceClientException.setServiceResponse(apiResponse);
				throw ServiceClientException;
			}
		} finally {
			if (baseRequest != null) {
				baseRequest.abort();
			}
		}
		return null;
	}

	/**
	 * This function is used to handle central status code & to perform
	 * appropriate actions
	 * 
	 * @param statusCode
	 * @param reason
	 * @param url
	 * @throws ServiceClientException
	 * @throws IOException
	 * @since Feb 11, 2017 2:46:35 PM
	 */
	private void handleOtherCases(int statusCode, String reason, String url, String apiResponse)
			throws ServiceClientException {

		ServiceClientException internalServersException = new ServiceClientException();
		internalServersException.setStatusCode(statusCode);
		internalServersException.setExceptionMessage(
				String.format("Status Code : %d for URL : %s With Reason : %s", statusCode, url, reason));
		internalServersException.setServiceResponse(apiResponse);
		throw internalServersException;
	}

	/**
	 * This function is used to provide HTTPclinet connection
	 * 
	 * @param url
	 * @param useProxy
	 * @return
	 * @throws IOException
	 * @since Feb 11, 2017 2:47:21 PMR
	 */
	private HttpClient getClientConnection(final String url, boolean useProxy) throws IOException {

		boolean isProxyEnabled = Boolean
				.valueOf(environment.getProperty(CorePropertiesConstants.CORE_PROXY_ENABLE.getPropertyValue()));
		if (isProxyEnabled && useProxy) {
			HttpHost proxy = new HttpHost(
					environment.getProperty(CorePropertiesConstants.CORE_PROXY_IP.getPropertyValue()), Integer.parseInt(
							environment.getProperty(CorePropertiesConstants.CORE_PROXY_PORT.getPropertyValue())));
			Credentials credentials = new UsernamePasswordCredentials(
					environment.getProperty(CorePropertiesConstants.CORE_PROXY_USERNAME.getPropertyValue()),
					environment.getProperty(CorePropertiesConstants.CORE_PROXY_PASSWORD.getPropertyValue()));
			AuthScope authScope = new AuthScope(
					environment.getProperty(CorePropertiesConstants.CORE_PROXY_IP.getPropertyValue()), Integer.parseInt(
							environment.getProperty(CorePropertiesConstants.CORE_PROXY_PORT.getPropertyValue())));
			CredentialsProvider credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(authScope, credentials);

			DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
			CloseableHttpClient httpclient = HttpClients.custom().setRoutePlanner(routePlanner)
					.setDefaultCredentialsProvider(credsProvider).build();
			return httpclient;
		} else {
			HttpClient client = HttpClientBuilder.create().build();
			return client;
		}
	}

	/**
	 * This function is used to provide {@link HttpClient} based on passed
	 * {@link RequestMethod}
	 * 
	 * @param url
	 * @param type
	 * @return
	 * @since Feb 11, 2017 2:47:55 PM
	 */
	private HttpRequestBase getHttpClient(final String url, final RequestMethod type) {
		if (type.equals(RequestMethod.GET)) {
			return new HttpGet(url);
		} else if (type.equals(RequestMethod.POST)) {
			return new HttpPost(url);
		} else if (type.equals(RequestMethod.PUT)) {
			return new HttpPut(url);
		} else if (type.equals(RequestMethod.DELETE)) {
			return new CoreDelete(url);
		}
		return new HttpGet(url);
	}

	/**
	 * Default Object mapper for JSON parsing
	 * 
	 * @return
	 * @since Feb 11, 2017 2:48:32 PM
	 */
	private ObjectMapper getMapper() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper;
	}

	/**
	 * get response headers
	 * 
	 * @return
	 * @since Feb 11, 2017 2:48:47 PM
	 */
	public Map<String, String> getResponseHeaders() {
		return responseHeaders;
	}
	/**
	 * @return the allResponseHeaders
	 */
	public Header[] getAllResponseHeaders() {
		return allResponseHeaders;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "AsyncServiceTask [environment=" + environment + ", xmlParser=" + xmlParser + ", responseHeaders="
				+ responseHeaders + ", serviceInfo=" + serviceInfo + "]";
	}

}
