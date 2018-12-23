/**
 * Copyright (c) 2018 Thomas Rokicki
 */

package application.spring.configurations;

import org.springframework.stereotype.Component;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * Class to access the collections in a neat manor for the Accessor classes.
 * 
 * @author Thomas Rokicki
 *
 */
@Component
public class CollectionAccessor {

	public static DBCollection getPersistentDataCollection() {
		MongoClient client = MongoSingleton.getInstance();
		return client.getDB("aqua").getCollection("persistentData");
	}

	public static DBCollection getLiveDataCollection() {
		MongoClient client = MongoSingleton.getInstance();
		return client.getDB("aqua").getCollection("liveData");
	}

	public static DBCollection getSensorCollection() {
		MongoClient client = MongoSingleton.getInstance();
		return client.getDB("aqua").getCollection("sensor");
	}

}
