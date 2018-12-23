/**
 * Copyright (c) 2018 Thomas Rokicki
 */

package application.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED, reason = "Not Implemented")
public class NotImplementedErrorException extends Exception {

	/**
	 * Auto Generated
	 */
	private static final long serialVersionUID = -2692078070838784120L;

	/**
	 * An Internal Server Error Exception with default error message
	 */
	public NotImplementedErrorException() {
		super("This method is not yet implemented.");
	}

	/**
	 * An Exception with custom error message
	 */
	public NotImplementedErrorException(String errorMessage) {
		super(errorMessage);
	}

	/**
	 * An Exception with throwable
	 * 
	 * @param t
	 */
	public NotImplementedErrorException(Throwable t) {
		super("This method is not yet implemented.", t);
	}

	/**
	 * An Internal Server Error Exception with custom error message and throwable
	 * 
	 * @param errorMessage
	 * @param t
	 */
	public NotImplementedErrorException(String errorMessage, Throwable t) {
		super(errorMessage, t);
	}

}
