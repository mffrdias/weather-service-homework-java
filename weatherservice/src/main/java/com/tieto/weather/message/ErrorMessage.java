package com.tieto.weather.message;

/**
 * This message is to be retrieved in the presence of an error.
 * The error can be a missing object of a more generic HTTP Client Errors (400+)
 * @author Manuel Dias
 *
 */
public class ErrorMessage extends Message{
	private String error = null;

	/**
	 * Retreives the error message
	 * @return The message
	 */
	public String getError() {
		return error;
	}

	/**
	 * Sets the error message
	 * @param error The message
	 */
	public void setError(String error) {
		this.error = error;
	}
}
