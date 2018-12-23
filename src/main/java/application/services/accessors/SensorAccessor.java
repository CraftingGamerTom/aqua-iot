/**
 * Copyright (c) 2018 Thomas Rokicki
 */

package application.services.accessors;

import java.util.Map;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoTimeoutException;
import com.mongodb.WriteResult;

import application.models.entity.Sensor;
import application.models.entity.request.SensorPostRequest;
import application.models.entity.request.SensorUpdateRequest;
import application.services.exceptions.ConflictException;
import application.services.exceptions.InternalServerErrorException;
import application.services.exceptions.NotAcceptableException;
import application.services.exceptions.NotFoundException;
import application.services.mappers.SensorDocumentMapper;
import application.spring.configurations.CollectionAccessor;

@Component
public class SensorAccessor {

	private static final Logger logger = Logger.getLogger(SensorAccessor.class);

	public static Sensor getByDatabaseId(Integer id) {
		DBCollection collection = CollectionAccessor.getSensorCollection();
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.append("id", id);
		DBObject doc = collection.find(searchQuery).one();
		Sensor object = SensorDocumentMapper.map(doc);
		return object;
	}

	public static Sensor getById(String id) throws NotFoundException, InternalServerErrorException {
		DBCollection collection = CollectionAccessor.getSensorCollection();
		try {
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.append("id", id);
			DBObject doc = collection.find(searchQuery).one();

			if (doc != null) {
				return SensorDocumentMapper.map(doc);
			} else {
				throw new NotFoundException();
			}
		} catch (MongoTimeoutException mte) { // Could not connect to database
			logger.error("Is the database running?", mte);
			throw new InternalServerErrorException("Is the database running?", mte);
		}
	}

	public static Sensor post(SensorPostRequest request)
			throws InternalServerErrorException, NotAcceptableException, JsonProcessingException, NotFoundException {
		DBCollection collection = CollectionAccessor.getSensorCollection();
		ensureIdIsUnique(request.getId());

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = mapper.convertValue(request, Map.class);
		BasicDBObject object = new BasicDBObject();
		object.putAll(map);
		collection.insert(object);

		Sensor response = getById(request.getId());
		return response;
	}

	public static Sensor update(String id, SensorUpdateRequest request)
			throws NotFoundException, InternalServerErrorException {
		DBCollection collection = CollectionAccessor.getSensorCollection();
		// TODO Ensure the fields are valid before updating
		BasicDBObject updates = new BasicDBObject();
		if (request.getName() != null) {
			// TODO Require Security to set this
			updates.append("name", request.getName());
		}

		BasicDBObject query = new BasicDBObject();
		query.put("id", id);
		collection.update(query, updates);
		Sensor response = getById(id);
		return response;
	}

	public static Sensor delete(String id) throws NotFoundException, InternalServerErrorException {
		DBCollection collection = CollectionAccessor.getSensorCollection();
		try {

			BasicDBObject query = new BasicDBObject();
			query.put("id", id);

			Sensor response = getById(id);
			WriteResult result = collection.remove(query);
			result.getN();
			if (result.getN() == 0) {
				throw new NotFoundException("Error performing DELETE.");
			} else if (result.getN() == 1) {
				return response;
			} else {
				throw new InternalServerErrorException("Expected only one delete");
			}

		} catch (NotFoundException nfe) {
			throw nfe;
		} catch (Exception e) {
			throw new InternalServerErrorException("Error performing GET.");
		}
	}

	private static void ensureIdIsUnique(String id) throws InternalServerErrorException, NotAcceptableException {
		DBCollection collection = CollectionAccessor.getSensorCollection();
		// Validate email
		if (id.isEmpty()) {
			throw new NotAcceptableException(NotAcceptableException.ID_TAKEN);
		} else {
			try {
				// Query by email address
				BasicDBObject query = new BasicDBObject();
				query.put("id", Pattern.compile(id, Pattern.CASE_INSENSITIVE));

				DBObject searchResult = collection.find(query).one();
				if (searchResult == null) {
					logger.debug("Id is not taken");
					return; // Email is unique
				} else {
					logger.debug("Id is not unique");
					throw new ConflictException("Id is not unique");
				}

			} catch (Exception e) {
				logger.error("Error ensuring email is unique.", e);
				throw new InternalServerErrorException();
			}
		}
	}

}
