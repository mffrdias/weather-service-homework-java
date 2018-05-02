package com.tieto.weather.data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tieto.weather.JsonServiceLogic;
import com.tieto.weather.exception.DataLoadingException;
import com.tieto.weather.City;

/**
 * Loads data from a list of file names. This names are parameterized during the
 * object construction. Implements {@link Loader}.
 * 
 * @author Manuel Dias
 *
 */
public abstract class FileLoader implements Loader {

	// not thread safe
	protected static Map<String, City> cities = new HashMap<>();
	protected List<String> fileLst;

	private static final Logger log = LoggerFactory.getLogger(JsonServiceLogic.class);

	/**
	 * Instantiate the object creating a list of files
	 * 
	 * @param files
	 *            The list file names to be loaded
	 */
	public FileLoader(List<String> files) {
		this.fileLst = files;
	}

	protected abstract void readContent(Reader reader) throws DataLoadingException;

	@Override
	public Map<String, City> loadData() throws DataLoadingException {
		long start = System.currentTimeMillis();
		log.debug("JSON parser started");

		for (String fileName : fileLst) {

			FileReader reader = null;

			try {
				reader = new FileReader(fileName);
				readContent(reader);
			} catch (FileNotFoundException e) {
				throw new DataLoadingException(e.getMessage());
			}
		}

		log.debug("JSON parser ended in " + (System.currentTimeMillis() - start) + " miliseconds");
		return cities;
	}
}
