package com.tieto.weather.exception;

/**
 * Enumerates the different exit codes for the Spring Boot application
 * Used for returning a exit code != 0 in the presence of a fatal error
 * @author Manuel Dias
 *
 */
public enum ExitCode {
	SUCCESS(0), FAILURE(-1);

	private int returnCode;

	private ExitCode(int returnCode) {
		this.returnCode = returnCode;
	}

	/**
	 * Retrieves the return code
	 * @return The exit code
	 */
	public int getReturnCode() {
		return returnCode;
	}
}
