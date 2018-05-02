package com.tieto.weather.message;

/**
 * Stores and retrieves an object T containing the data to be returned by the service
 * @author Manuel Dias
 *
 * @param <T> The object to be stored
 */
public class DataMessage<T> extends Message {
	private T data;

	/**
	 * Retrieves the data
	 * @return The generic data object
	 */
	public T getData() {
		return data;
	}

	/**
	 * Sets a new data object
	 * @param data The generic object
	 */
	public void setData(T data) {
		this.data = data;
	}
}
