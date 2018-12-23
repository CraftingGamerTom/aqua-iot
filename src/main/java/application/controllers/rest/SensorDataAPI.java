/**
 * Copyright (c) 2018 Thomas Rokicki
 */

package application.controllers.rest;

import java.time.ZonedDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import application.models.constants.AveragingMethod;
import application.models.entity.Sensor;
import application.models.entity.SensorData;
import application.models.entity.request.SensorDataPutRequest;
import application.models.entity.response.SensorDataList;
import application.services.accessors.SensorDataAccessor;
import application.services.exceptions.NotFoundException;
import application.services.exceptions.NotImplementedErrorException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "api/v1/sensors")
@Api(value = "Sensor Data", tags = { "Sensor Data" })
public class SensorDataAPI {
	private static Logger logger = Logger.getLogger(SensorDataAPI.class);

	@ApiOperation(value = "Create Sensor Data", response = Sensor.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED", response = SensorData.class),
			@ApiResponse(code = 400, message = "Bad Request") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{id}/data", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public SensorData post(@ApiParam(value = "The Sensor Id") @PathVariable("id") String id,
			@ApiParam(value = "Sensor Data", required = true) @RequestBody SensorDataPutRequest request)
			throws NotImplementedErrorException {
		logger.trace("POST /sensors/{id}/data");
		throw new NotImplementedErrorException();
	}

	@ApiOperation(value = "Get Sensor Data", response = SensorDataList.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{id}/data", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public SensorDataList getById(@ApiParam(value = "The Sensor Id") @PathVariable("id") String id,
			@RequestParam("startDate") ZonedDateTime startDate, @RequestParam("finishDate") ZonedDateTime finishDate,
			@RequestParam("averageMethod") AveragingMethod method) {
		logger.trace("GET /sensors/{id}/data?startdate=EXAMPLE&finishDate=EXAMPLE");
		SensorDataList response = SensorDataAccessor.get(id, startDate, finishDate, method);
		return response;
	}

	@ApiOperation(value = "Get Live Sensor Data", response = SensorData.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{id}/data/live", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public SensorData getLiveData(@ApiParam(value = "The Sensor Id") @PathVariable("id") String id)
			throws NotFoundException {
		logger.debug("GET /sensors/{id}/data/live");
		SensorData response = SensorDataAccessor.getLiveData(id);
		return response;
	}

	@ApiOperation(value = "Delete Sensor by Id [NOT IMPLEMENTED]", response = SensorDataList.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/sensors/{id}/data", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SensorDataList deleteById(@ApiParam(value = "The Sensor Id") @PathVariable("id") String id,
			@RequestParam("startDate") ZonedDateTime startDate, @RequestParam("finishDate") ZonedDateTime finishDate)
			throws NotImplementedErrorException {
		logger.trace("DELETE /sensors/{id}");
		throw new NotImplementedErrorException();
	}
	
	

}
