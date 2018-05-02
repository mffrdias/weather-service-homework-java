package com.tieto.weather.data;

import java.util.Map;

import com.tieto.weather.City;
import com.tieto.weather.exception.DataLoadingException;

/**
 * Represents a the interface of a loader.
 * Objects implementing Loader class are managed by {@link LoaderFactory}
 * 
 * @author Manuel Dias
 * @version 1.0
 */
public interface Loader {

	/**
	 * Loads data and returns a data structures containing the info
	 * @return	A map containing the pair, name of the city and the corresponding object
	 * @throws DataLoadingException Throws an exception if an error occurred during the parsing
	 */
	Map<String, City> loadData() throws DataLoadingException;
}
