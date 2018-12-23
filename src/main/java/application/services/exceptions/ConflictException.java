/**
 * Copyright (c) 2018 Thomas Rokicki
 */

package application.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Conflict")
public class ConflictException extends Exception {

	/**
	 * Auto Generated
	 */
	private static final long serialVersionUID = -2627513306835505413L;

	public static final String EMAIL_NOT_UNIQUE = "Email is taken.";
	public static final String USERNAME_NOT_UNIQUE = "Username is taken.";

	/**
	 * An Internal Server Error Exception with default error message
	 */
	public ConflictException() {
		super("A conflict occured.");
	}

	/**
	 * An Internal Server Error Exception with custom error message
	 */
	public ConflictException(String errorMessage) {
		super(errorMessage);
	}
}
