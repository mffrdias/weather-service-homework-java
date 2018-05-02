package com.tieto.weather;

import java.time.LocalDate;
import java.util.Map;

/**
 * Represents a location, e.g. a city
 * 
 * @author Manuel Dias
 */
public interface Location {
	
	/**
	 * Retrieves the location name
	 * @return The name
	 */
	public String getName();

	/**
	 * Retrieves a maximum temperature for the given date
	 * @param date The date
	 * @return A double value with the temperature
	 */
	public Double getTemperature(LocalDate date);

	/**
	 * Retrieves all maximum temperatures 
	 * @return A map containing the pair Data-Temperature
	 */
	public Map<LocalDate, Double> getAllMaxTemps();

	/**
	 * Checks if temperature exists for the specified date 
	 * @param date The date to search
	 * @return <code>true</code> if contains; otherwise <code>false</code>
	 */
	public boolean containsTemperature(LocalDate date);

	/**
	 * Adds a new maximum temperature for the specified date
	 * @param date The date
	 * @param value The maximum temperature
	 * @return <code>true</code> if successful; otherwise <code>false</code>
	 */
	public boolean addTemperature(LocalDate date, Double value);

}
