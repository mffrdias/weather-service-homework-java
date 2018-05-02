package com.tieto.weather;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

/**
 * POJO representing a city with a map containing the maximum daily temperatures 
 * @author 	Manuel Dias
 * @version 1.0
 */
public class City implements Location, Comparable<City> {

	private String name;
	private Map<LocalDate, Double> temperatures; // autoboxing for max_temperature
	
	public City() {
		temperatures = new TreeMap<>();
	}

	public City(String cityName) {
		this();
		this.name = cityName;
	}

	public String getName() {
		return name;
	}

	public void setName(String cityName) {
		this.name = cityName;
	}
	
	@Override
	public Double getTemperature(LocalDate date) {
		return temperatures.get(date);
	}
	
	@Override
	public Map<LocalDate, Double> getAllMaxTemps() {
		return temperatures;
	}

	@Override
	public int compareTo(City city) {
		return this.name.compareTo(city.getName());
	}

	// TODO: check for duplicates or use a Set
	@Override
	public boolean addTemperature(LocalDate date, Double value) {
		return (temperatures.put(date, value) != null) ? true : false;
	}

	@Override
	public boolean containsTemperature(LocalDate date) {
		return temperatures.containsKey(date);
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", temperatures=" + temperatures + "]";
	}

}
