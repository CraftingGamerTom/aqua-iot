/**
 * Copyright (c) 2018 Thomas Rokicki
 */

package application.services.mappers;

import java.time.ZonedDateTime;
import org.apache.log4j.Logger;
import com.mongodb.DBObject;

import application.models.entity.SensorData;

public class SensorDataDocumentMapper {

	final static Logger logger = Logger.getLogger(SensorDataDocumentMapper.class);

	public static SensorData map(DBObject dbobject) {
		SensorData object = new SensorData();
		object.setDatabaseId(dbobject.get("_id").toString());
		object.setId(dbobject.get("id").toString());
		object.setValue(Double.parseDouble(dbobject.get("value").toString()));
		object.setIngestionDate(ZonedDateTime.parse(dbobject.get("ingestionDate").toString() + "Z"));
		object.setMeasureDate(ZonedDateTime.parse(dbobject.get("measureDate").toString() + "Z"));

		return object;
	}

}
