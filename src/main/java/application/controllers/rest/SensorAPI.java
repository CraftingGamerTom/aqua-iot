/**
 * Copyright (c) 2018 Thomas Rokicki
 */

package application.controllers.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import application.models.entity.Sensor;
import application.models.entity.request.SensorPostRequest;
import application.models.entity.request.SensorUpdateRequest;
import application.services.accessors.SensorAccessor;
import application.services.exceptions.InternalServerErrorException;
import application.services.exceptions.NotAcceptableException;
import application.services.exceptions.NotFoundException;
import application.services.exceptions.NotImplementedErrorException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "api/v1/sensors")
@Api(value = "Sensor", tags = { "Sensor" })
public class SensorAPI {
	private final static Logger logger = Logger.getLogger(SensorAPI.class);

	@ApiOperation(value = "Create Sensor", response = Sensor.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED", response = Sensor.class),
			@ApiResponse(code = 400, message = "Bad Request") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Sensor post(@ApiParam(value = "Sensor information", required = true) @RequestBody SensorPostRequest request)
			throws JsonProcessingException, InternalServerErrorException, NotAcceptableException, NotFoundException {
		logger.trace("POST /sensors");

		Sensor response = SensorAccessor.post(request);
		return response;
	}

	@ApiOperation(value = "Update Sensor", response = Sensor.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Sensor updateById(@ApiParam(value = "The Sensor Id") @PathVariable("id") String id,
			@ApiParam(value = "Sensor information", required = true) @RequestBody SensorUpdateRequest request)
			throws NotFoundException, InternalServerErrorException {
		logger.trace("PUT /sensors/{id}");
		Sensor response = SensorAccessor.update(id, request);
		return response;
	}

	@ApiOperation(value = "Get Sensor by Id", response = Sensor.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Sensor getById(@ApiParam(value = "The Sensor Id") @PathVariable("id") String id)
			throws NotFoundException, InternalServerErrorException {
		logger.trace("GET /sensors/{id}");
		Sensor response = SensorAccessor.getById(id);
		return response;
	}

	@ApiOperation(value = "Delete Sensor by Id [NOT IMPLEMENTED]", response = Sensor.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/sensors/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Sensor deleteById(@ApiParam(value = "The Sensor Id") @PathVariable("id") String id)
			throws NotImplementedErrorException {
		logger.trace("DELETE /sensors/{id}");
		throw new NotImplementedErrorException();
	}

}
