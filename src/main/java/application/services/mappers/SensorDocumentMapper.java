/**
 * Copyright (c) 2018 Thomas Rokicki
 */

package application.services.mappers;

import java.time.ZonedDateTime;
import org.apache.log4j.Logger;
import com.mongodb.DBObject;

import application.models.entity.Sensor;

public class SensorDocumentMapper {

	final static Logger logger = Logger.getLogger(SensorDocumentMapper.class);

	public static Sensor map(DBObject doc) {
		Sensor object = new Sensor();
		object.setDatabaseId(doc.get("_id").toString());
		object.setId(doc.get("id").toString());
		object.setName(doc.get("name").toString());
		object.setCreatedDate(ZonedDateTime.parse(doc.get("createdDate").toString()));
		object.setType(doc.get("type").toString());

		return object;
	}

}
