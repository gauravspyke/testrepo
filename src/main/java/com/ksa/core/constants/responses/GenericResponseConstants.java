package com.ksa.core.constants.responses;



/**This enum lists all the response messages and the associated codes and HTTP status code for generic responses
 * that are common between all modules.
 * ResponseConstants.java Class
 * @version 1.0
 * @author Amrita Upreti
 * @since Jan 23, 2017
 */
public enum GenericResponseConstants implements IResponseConstant{

	SUCCESS(200, 200, "Success"),
	CREATED(201, 201, "Success"),
	DB_SERVICE_NOT_AVAILABLE(500, 500, "Internal Server Error"),
	INTERNAL_SERVER_ERROR(500, 500, "Internal Server Error"),
	UNAUTHORIZED_ACCESS(401, 401, "Unauthorized Access"),
	GATEWAY_TIMEOUT(504, 504, "Gateway Timeout"),
	INCORRECT_MEDIA_TYPE(400, 400, "Incorrect Media Type "),
	RESOURCE_NOT_FOUND(404,404,"Resource Not Found"),
	INCORRECT_REQUEST_FORMAT(400, 400, "Incorrect Input Request Format"),
	USER_ALREADY_AUTHENTICATED(200,200,"User Already Authenticated"),
	NO_AUTHENTICATED_USER(420,420,"No Authenticated User Found"),
	JSON_PARSING_FAILED(420,420,"JSON Parsing Failed"),
	NUMBER_CONVERSION_FAILED(420,420,"Number Conversion Failed"),
	CURRENT_SESSION_INVALIDATED(200,200,"Current Session invalidated successfully");
	private int httpStatusCode;
	private int responseCode;
	private String responseText;
	
	/**
	 * @param httpStatusCode
	 * @param responseCode
	 * @param responseText
	 */
	private GenericResponseConstants(int httpStatusCode, int responseCode,
			String responseText) {
		this.httpStatusCode = httpStatusCode;
		this.responseCode = responseCode;
		this.responseText = responseText;
	}
	
	/**
	 * @see com.ksa.ckout.api.constants.responses.IResponseConstant#getHttpStatusCode()
	 */
	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	/**
	 * @see com.ksa.ckout.api.constants.responses.IResponseConstant#getResponseCode()
	 */
	public int getResponseCode() {
		return responseCode;
	}

	/**
	 * @see com.ksa.ckout.api.constants.responses.IResponseConstant#getResponseText()
	 */
	public String getResponseText() {
		return responseText;
	}	
}
