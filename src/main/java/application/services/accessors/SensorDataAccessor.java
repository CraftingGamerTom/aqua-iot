package application.services.accessors;

import java.time.ZonedDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import application.models.constants.AveragingMethod;
import application.models.entity.SensorData;
import application.models.entity.response.SensorDataList;
import application.services.exceptions.NotFoundException;
import application.services.mappers.SensorDataDocumentMapper;
import application.spring.configurations.CollectionAccessor;

@Component
public class SensorDataAccessor {

	final static Logger logger = Logger.getLogger(SensorDataAccessor.class);

	public static SensorDataList get(String id, ZonedDateTime startDate, ZonedDateTime finishDate,
			AveragingMethod method) {
		// TODO Auto-generated method stub
		return null;
	}

	public static SensorData getLiveData(String id) throws NotFoundException {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.append("id", id);

		DBCollection collection = CollectionAccessor.getLiveDataCollection();
		DBObject dbobject = collection.find(searchQuery).one();
		if (dbobject != null) {
			SensorData response = SensorDataDocumentMapper.map(dbobject);

			logger.debug("Ingestions Time: " + response.getIngestionDate().toString());
			return response;
		} else {
			throw new NotFoundException();
		}
	}

}
