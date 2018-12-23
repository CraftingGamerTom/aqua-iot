/**
 * Copyright (c) 2018 Thomas Rokicki
 */

package application.spring.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.yml")
@ConfigurationProperties("server")
public class AppConfig {
	@Autowired
	private ServerConfig serverConfig;

	@Autowired
	private ApiConfig apiConfig;

	public ServerConfig getServerConfig() {
		return serverConfig;
	}

	public void setServerConfig(ServerConfig serverConfig) {
		this.serverConfig = serverConfig;
	}

	public ApiConfig getApiConfig() {
		return apiConfig;
	}

	public void setApiConfig(ApiConfig apiConfig) {
		this.apiConfig = apiConfig;
	}

	@Configuration
	@PropertySource("classpath:application.yml")
	@ConfigurationProperties("server")
	public class ServerConfig {
		private int port;

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}
	}

	@Configuration
	@PropertySource("classpath:application.yml")
	@ConfigurationProperties("api")
	public class ApiConfig {
		private String hostname;

		private String version;

		public String getHostname() {
			return hostname;
		}

		public void setHostname(String hostname) {
			this.hostname = hostname;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}
	}
}
