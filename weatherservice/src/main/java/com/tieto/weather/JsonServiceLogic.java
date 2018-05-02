package com.tieto.weather;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tieto.weather.data.Loader;
import com.tieto.weather.data.LoaderFactory;
import com.tieto.weather.exception.DataLoadingException;
import com.tieto.weather.exception.ExitCode;

/**
 * api key
 * 
 * e5c4ae24bc53ea8386243483cc4525ee
 * 
 * This SpringBoot application receives a filename with the weather information
 * for a set of cities. It will exit the application with an exit code
 * {@link ExitCode} if it cannot successfully parse the supplied JSON file.
 * 
 * @author Manuel Dias
 * @version 1.0
 */
@SpringBootApplication
public class JsonServiceLogic implements ServiceLogic {

	private static ConfigurableApplicationContext ctx;
	private static Map<String, City> cityMap = new HashMap<>();
	private static Loader jsonloader = null;

	@Override
	public void loadData(String... args) throws DataLoadingException {
		jsonloader = LoaderFactory.createLoader(LoaderFactory.LoadingType.JSONFILE, args);
		cityMap = jsonloader.loadData();
	}

	@Override
	public Location getCity(String cityName) {
		return cityMap.get(cityName);
	}

	@Override
	public Map<LocalDate, Double> getCityTemperatures(String cityName) {
		if (cityMap.containsKey(cityName)) {
			return cityMap.get(cityName).getAllMaxTemps();
		}
		return null;
	}

	@Override
	public Collection<String> getAllCityNames() {
		return cityMap.keySet();
	}

	@Override
	public boolean addCity(String cityName) {
		if (cityMap.containsKey(cityName))
			return false;

		cityMap.put(cityName, new City(cityName));
		return true;
	}

	/**
	 * Starts a Spring Boot application.
	 * <p>
	 * Usage: <code>java -jar *.jar filename1 [filename2] [filenameN]</code>
	 * </p>
	 * 
	 * @param args
	 *            List of file names
	 * @throws DataLoadingException
	 *             The exception thrown during data reading
	 */
	public static void main(String args[]) throws DataLoadingException {

		// validate number of arguments
		if (args.length == 0)
			throw new DataLoadingException("Invalid number of arguments");

		// starting spring and passing the current context to the loading exception
		ctx = SpringApplication.run(JsonServiceLogic.class, args);
		DataLoadingException.setApplicationContext(ctx);

		// Dependency Injection. Business logic object set to the controller,
		// abstracting from this implementation
		ServiceLogic bsLogic = new JsonServiceLogic();
		Controller.setBusinessLogic(bsLogic);

		// loading business data
		bsLogic.loadData(args);
	}
}