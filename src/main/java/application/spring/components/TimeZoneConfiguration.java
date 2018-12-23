/**
 * Copyright (c) 2018 Thomas Rokicki
 */

package application.spring.components;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class TimeZoneConfiguration {
	@PostConstruct
	public void postConstruct() {
		// set the JVM timezone to UTC
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}
