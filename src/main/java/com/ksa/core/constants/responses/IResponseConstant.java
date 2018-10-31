package com.ksa.core.constants.responses;

/** Sets the interface to access the HTTP Code, response code, response text
 * IResponseConstant.java Class
 * @version 1.0
 * @author Amrita Upreti
 * @since Jan 23, 2017
 */
public interface IResponseConstant {

	/**Returns the HTTP status code
	 * getHttpStatusCode method
	 * @return
	 * @since Jan 23, 2017
	 */
	public int getHttpStatusCode();
	
	/**Returns the Response code
	 * getResponseCode method
	 * @return
	 * @since Jan 23, 2017
	 */
	public int getResponseCode() ;
	
	/**Returns the response text message
	 * getResponseText method
	 * @return
	 * @since Jan 23, 2017
	 */
	public String getResponseText() ;
	
}
