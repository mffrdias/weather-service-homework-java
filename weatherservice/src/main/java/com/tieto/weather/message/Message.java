package com.tieto.weather.message;

import org.springframework.http.HttpStatus;

/**
 * Generic message to be returned by the rest controller. This message can be
 * extended to different attributes and its main purpose it to return the
 * success of an operation. The default return status is 200.
 * 
 * @author Manuel Dias
 *
 */
public class Message {
	protected Boolean success = null;
	protected Integer status = HttpStatus.OK.value();

	/**
	 * Retrieves the HTTP status code. default status OK (200) 
	 * @return The HTTP status code
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Sets a different status than the default 200 (OK)
	 * @param status Status code
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Default constructor
	 */
	public Message() {
	}

	/**
	 * Sets the success of the operation
	 * 
	 * @param success
	 *            <code>true</code> if operation successful;<code>false</code>
	 *            otherwise
	 */
	public Message(Boolean success) {
		this.success = success;
	}

	/**
	 * Retrieves the success of the operation
	 * 
	 * @return <code>true</code> if successful;<code>false</code> otherwise
	 */
	public Boolean getSuccess() {
		return success;
	}

	/**
	 * Sets the success of the operation
	 * 
	 * @param success
	 *            <code>true</code> if operation successful;<code>false</code>
	 *            otherwise
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}
}