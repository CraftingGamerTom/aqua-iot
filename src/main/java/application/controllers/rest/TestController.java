/**
 * Copyright (c) 2018 Thomas Rokicki
 */

package application.controllers.rest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("api")
@Api(value = "TEST CONTROLLERS", tags = { "TEST CONTROLLERS" })
public class TestController {
	private static Logger logger = Logger.getLogger(TestController.class);

	private static final String v1_test = "v1/test";

	@RequestMapping(value = v1_test + "/call", method = RequestMethod.GET)
	public String recieveSensorData() {
		logger.debug("Hit test endpoint.");
		return "Test Passed.";
	}
}
