/**
 * Copyright (c) 2018 Thomas Rokicki
 */

package application.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Common {

	final static Logger logger = Logger.getLogger(Common.class);

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test() {
		logger.debug("Reached Endpoint");

		return "test";
	}
}