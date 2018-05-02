package com.tieto.weather.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.tieto.weather.JsonServiceLogic;

/**
 * This exception is to be thrown in the occurrence of an fatal error during
 * data loading. Only throw this message if doesn't make sense to proceed with
 * the execution.
 * 
 * @author Manuel Dias
 *
 */
public class DataLoadingException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(JsonServiceLogic.class);

	private static ApplicationContext appContext;

	/**
	 * Sets the spring application context so the exception can control if the
	 * application stops
	 * 
	 * @param ctx
	 *            the Spring Boot context
	 */
	public static void setApplicationContext(ApplicationContext ctx) {
		appContext = ctx;
	}

	/**
	 * 
	 * @param msg
	 *            the message to be logged
	 */
	public DataLoadingException(String msg) {
		super(msg);
		log.error(msg);
		SpringApplication.exit(appContext, () -> ExitCode.FAILURE.getReturnCode());
	}
}
