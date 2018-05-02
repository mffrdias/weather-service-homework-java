package com.tieto.weather.data;

import java.io.Reader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.tieto.weather.City;
import com.tieto.weather.exception.DataLoadingException;

/**
 * This class extends {@link FileLoader} and parses
 * 
 * @author Manuel Dias
 * @version 1.0
 */
public class JsonLoader extends FileLoader {

	/**
	 * Receives a list of file names and forwards them to the parent contructor
	 * @param fileLst The list of files to load
	 */
	public JsonLoader(List<String> fileLst) {
		super(fileLst);
	}

	/**
	 * Parses the input file using GSON library.
	 * 
	 * @throws DataLoadingException
	 *             If json syntax is not correct or in the presence of any IO
	 *             exceptions
	 */
	@Override
	protected void readContent(Reader reader) throws DataLoadingException {

		try {
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(reader);

			// get list of cities
			JsonArray arr = element.getAsJsonObject().get("cities").getAsJsonArray();

			// iterate over cities
			for (JsonElement jcity : arr) {

				// LEFT:city name | RIGHT:json element holding the temperatures
				Entry<String, JsonElement> nameTempPair = jcity.getAsJsonObject().entrySet().iterator().next();
				City newcity = new City(nameTempPair.getKey());

				// parsing city's temperatures
				Type listType = new TypeToken<ArrayList<HashMap<String, Integer>>>() {
				}.getType();
				ArrayList<Map<String, Integer>> tempList = new Gson().fromJson(nameTempPair.getValue(), listType);

				for (Map<String, Integer> temperature : tempList) {

					// add the temperature to city object
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
					temperature.entrySet().forEach(entry -> newcity
							.addTemperature(LocalDate.parse(entry.getKey(), formatter), new Double(entry.getValue())));
				}

				cities.put(newcity.getName(), newcity);
			}
		} catch (Throwable e) {
			throw new DataLoadingException(e.getMessage());
		}

	}
}
