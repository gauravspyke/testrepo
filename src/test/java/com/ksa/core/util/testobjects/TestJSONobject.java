package com.ksa.core.util.testobjects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * TestJSONobject.java Class is a POJO for testing JSOn utility
 * @version 1.0
 * @author Harsh Lal
 * @since Feb 8, 2017 4:32:41 PM
 */
public class TestJSONobject {
	
	/*Purchase Params*/
	private String command; 
	private String access_code; 
	private String merchant_identifier;
	private String merchant_reference;
	private String amount; 
	private String currency; 
	private String language; 
	private String customer_email; 
	private String signature; 
	private String fort_id; 
	private String payment_option; 
	private String sadad_olp; 
	private String eci;
	private String order_description; 
	private String customer_ip; 
	private String customer_name; 
	private String authorization_code;
	private String response_message;
	private String response_code; 
	private String status;
	private String expiry_date; 
	private String card_number;
	/*Merchant Channel*/
	private String token_name;
	@JsonProperty("3ds_url")
	private String resp3ds_url;
	private String remember_me;
	
	/**
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}
	/**
	 * @param command the command to set
	 */
	public void setCommand(String command) {
		this.command = command;
	}
	/**
	 * @return the access_code
	 */
	public String getAccess_code() {
		return access_code;
	}
	/**
	 * @param access_code the access_code to set
	 */
	public void setAccess_code(String access_code) {
		this.access_code = access_code;
	}
	/**
	 * @return the merchant_identifier
	 */
	public String getMerchant_identifier() {
		return merchant_identifier;
	}
	/**
	 * @param merchant_identifier the merchant_identifier to set
	 */
	public void setMerchant_identifier(String merchant_identifier) {
		this.merchant_identifier = merchant_identifier;
	}
	/**
	 * @return the merchant_reference
	 */
	public String getMerchant_reference() {
		return merchant_reference;
	}
	/**
	 * @param merchant_reference the merchant_reference to set
	 */
	public void setMerchant_reference(String merchant_reference) {
		this.merchant_reference = merchant_reference;
	}
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the customer_email
	 */
	public String getCustomer_email() {
		return customer_email;
	}
	/**
	 * @param customer_email the customer_email to set
	 */
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}
	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}
	/**
	 * @return the fort_id
	 */
	public String getFort_id() {
		return fort_id;
	}
	/**
	 * @param fort_id the fort_id to set
	 */
	public void setFort_id(String fort_id) {
		this.fort_id = fort_id;
	}
	/**
	 * @return the payment_option
	 */
	public String getPayment_option() {
		return payment_option;
	}
	/**
	 * @param payment_option the payment_option to set
	 */
	public void setPayment_option(String payment_option) {
		this.payment_option = payment_option;
	}
	/**
	 * @return the sadad_olp
	 */
	public String getSadad_olp() {
		return sadad_olp;
	}
	/**
	 * @param sadad_olp the sadad_olp to set
	 */
	public void setSadad_olp(String sadad_olp) {
		this.sadad_olp = sadad_olp;
	}
	/**
	 * @return the eci
	 */
	public String getEci() {
		return eci;
	}
	/**
	 * @param eci the eci to set
	 */
	public void setEci(String eci) {
		this.eci = eci;
	}
	/**
	 * @return the order_description
	 */
	public String getOrder_description() {
		return order_description;
	}
	/**
	 * @param order_description the order_description to set
	 */
	public void setOrder_description(String order_description) {
		this.order_description = order_description;
	}
	/**
	 * @return the customer_ip
	 */
	public String getCustomer_ip() {
		return customer_ip;
	}
	/**
	 * @param customer_ip the customer_ip to set
	 */
	public void setCustomer_ip(String customer_ip) {
		this.customer_ip = customer_ip;
	}
	/**
	 * @return the customer_name
	 */
	public String getCustomer_name() {
		return customer_name;
	}
	/**
	 * @param customer_name the customer_name to set
	 */
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	/**
	 * @return the authorization_code
	 */
	public String getAuthorization_code() {
		return authorization_code;
	}
	/**
	 * @param authorization_code the authorization_code to set
	 */
	public void setAuthorization_code(String authorization_code) {
		this.authorization_code = authorization_code;
	}
	/**
	 * @return the response_message
	 */
	public String getResponse_message() {
		return response_message;
	}
	/**
	 * @param response_message the response_message to set
	 */
	public void setResponse_message(String response_message) {
		this.response_message = response_message;
	}
	/**
	 * @return the response_code
	 */
	public String getResponse_code() {
		return response_code;
	}
	/**
	 * @param response_code the response_code to set
	 */
	public void setResponse_code(String response_code) {
		this.response_code = response_code;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the expiry_date
	 */
	public String getExpiry_date() {
		return expiry_date;
	}
	/**
	 * @param expiry_date the expiry_date to set
	 */
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}
	/**
	 * @return the card_number
	 */
	public String getCard_number() {
		return card_number;
	}
	/**
	 * @param card_number the card_number to set
	 */
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	/**
	 * @return the token_name
	 */
	public String getToken_name() {
		return token_name;
	}
	/**
	 * @param token_name the token_name to set
	 */
	public void setToken_name(String token_name) {
		this.token_name = token_name;
	}
	/**
	 * @return the resp3ds_url
	 */
	public String getResp3ds_url() {
		return resp3ds_url;
	}
	/**
	 * @param resp3ds_url the resp3ds_url to set
	 */
	public void setResp3ds_url(String resp3ds_url) {
		this.resp3ds_url = resp3ds_url;
	}
	/**
	 * @return the remember_me
	 */
	public String getRemember_me() {
		return remember_me;
	}
	/**
	 * @param remember_me the remember_me to set
	 */
	public void setRemember_me(String remember_me) {
		this.remember_me = remember_me;
	}
}
