package com.tieto.weather;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

import com.tieto.weather.data.JsonLoader;
import com.tieto.weather.exception.DataLoadingException;

/**
 * Specifies an interface that a concrete business class should follow
 * 
 * @author Manuel Dias
 *
 */
public interface ServiceLogic {
	
	/**
	 * Creates a new {@link JsonLoader} and loads the files for the given array of file names.
	 * 
	 * @param args	The variable array of file names
	 * @throws DataLoadingException Throws an exception if couldn't read data successfully
	 */
	public void loadData(String... args) throws DataLoadingException;
	
	/**
	 * Gets the city for the given name
	 * 
	 * @param cityName	The name of the city
	 * @return			The corresponding {@link Location}
	 */
	public Location getCity(String cityName);

	/**
	 * Gets a Map with the city temperatures for the given name
	 * 
	 * @param cityName	The name of the city
	 * @return			The map with the Data-Temperature; otherwise null
	 */
	public Map<LocalDate, Double> getCityTemperatures(String cityName);
	
	/**
	 * Gets a collection of strings with the all city names loaded into memory
	 *  
	 * @return	The collection of names; otherwise null
	 */
	public Collection<String> getAllCityNames();
	
	/**
	 * Creates a new city with the given name
	 * 
	 * @param cityName	The name of the new city
	 * @return			<code>true</code> if it's a new city; otherwise <code>false</code>
	 */
	public boolean addCity(String cityName);
	
}
