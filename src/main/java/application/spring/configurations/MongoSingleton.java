package application.spring.configurations;

import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.mongodb.MongoClient;

import application.services.accessors.SensorAccessor;

public class MongoSingleton {

	private static final Logger logger = Logger.getLogger(MongoSingleton.class);
	private static MongoClient client = null;
	/*
	 * private static String DB_SRV_USR = MongoSecuritySingleton.getUsername();
	 * private static String DB_SRV_PWD = MongoSecuritySingleton.getPassword();
	 * private static String DB_URL = ConfigurationReaderSingleton.getDatabaseIP();
	 * private static int DB_PORT = ConfigurationReaderSingleton.getDatabasePort();
	 * private static String dbName =
	 * ConfigurationReaderSingleton.getDatabaseName();
	 */

	protected MongoSingleton() {

	}

	public static MongoClient getInstance() {
		if (client == null) {
			/*
			 * String uri = "mongodb://" + DB_SRV_USR + ":" + DB_SRV_PWD + "@" + DB_URL +
			 * ":" + DB_PORT + "/" + dbName + "?authSource=admin";
			 * 
			 * MongoClientURI mongoClientURI = new MongoClientURI(uri);
			 * 
			 * client = new MongoClient(mongoClientURI);
			 */

			String addr = "127.0.0.1";
			int port = 27017;

			String appenv = System.getenv("appenv");

			if (appenv != null) {
				if (System.getenv("appenv").equals("dev")) {
					logger.debug("Using dev environment");
					addr = "192.168.1.8";
					port = 27017;
				} else {
					logger.error("Unknown environment. Default is prod.");
				}

			} else {
				logger.debug("Using prod environment");
			}

			try {
				client = new MongoClient(addr, port);
				logger.debug("MongoBD Host created.");
			} catch (UnknownHostException e) {
				logger.error("Could not Resolve Host", e);
			}
		}
		return client;
	}
}
