package com.tieto.weather.data;

import java.util.Arrays;

/**
 * Factory class used for creating different catalog loading mechanisms
 * The available Loaders are listed by {@link LoadingType}.
 * 
 * @author Manuel Dias
 * 
 */
public final class LoaderFactory {
	
	// private constructor to avoid instantiation
	private LoaderFactory() { }
	
	/**
	 * Enumerates the different loading methods (e.g. file, database, web service, etc)
	 *  
	 * @author 	Manuel Dias
	 * @version	1.0
	 */
	public enum LoadingType {
		JSONFILE
		//, ORACLEDB
	}
	
	/**
	 * Creates a new data loader based in the {@link LoadingType}
	 * A list of variable arguments can be passed in order to parameterize the Loader
	 *  
	 * @param loaderType	The loading type 
	 * @param varargs 		Name of the file to be fetched
	 * @return 				A Loader
	 */
	public static Loader createLoader(LoadingType loaderType, String... varargs) { 
		
		Loader loader = null;
		
		switch(loaderType) {
			case JSONFILE : 
				if(varargs.length==0) {
					throw new IllegalArgumentException(LoadingType.JSONFILE+" should contain at least one file name");
				}
				loader = new JsonLoader(Arrays.asList(varargs));
				break;
		default:
			break;
		}
		
		return loader;
	}
}
