/**
 * Copyright (c) 2018 Thomas Rokicki
 */

package application.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not Found")
public class NotFoundException extends Exception {

	/**
	 * Auto Generated
	 */
	private static final long serialVersionUID = -7053834581688918244L;

	public static final String USER_NOT_FOUND = "User not found.";
	public static final String ORGANIZATION_NOT_FOUND = "Organization not found.";

	/**
	 * An Not Found Exception with default error message
	 */
	public NotFoundException() {
		super("The requested object could not be found.");
	}

	/**
	 * An Not Found Exception with custom error message
	 */
	public NotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
