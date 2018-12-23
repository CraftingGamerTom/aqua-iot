/**
 * Copyright (c) 2018 Thomas Rokicki
 */

package application.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
public class InternalServerErrorException extends Exception {

	/**
	 * Auto Generated
	 */
	private static final long serialVersionUID = -6243857608638709207L;

	public static final String UNKNOWN = "An unknown error occured. Falling back to an Internal Server Error.";

	/**
	 * An Internal Server Error Exception with default error message
	 */
	public InternalServerErrorException() {
		super("An Internal Server Error occured.");
	}

	/**
	 * An Internal Server Error Exception with custom error message
	 */
	public InternalServerErrorException(String errorMessage) {
		super(errorMessage);
	}

	/**
	 * An Internal Server Error Exception with custom error message
	 * 
	 * @param t
	 */
	public InternalServerErrorException(Throwable t) {
		super("An Internal Server Error occured.", t);
	}

	/**
	 * An Internal Server Error Exception with custom error message
	 * 
	 * @param errorMessage
	 * @param t
	 */
	public InternalServerErrorException(String errorMessage, Throwable t) {
		super(errorMessage, t);
	}

}
