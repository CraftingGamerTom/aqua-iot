package application.models.entity;

import java.time.ZonedDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import application.models.entity.request.SensorPostRequest;
import application.services.json.serializers.JsonDateSerializer;

public class Sensor {

	private String databaseId;
	private String id;
	private String name;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	@JsonSerialize(using = JsonDateSerializer.class)
	private ZonedDateTime createdDate;
	private String type;

	public Sensor() {
	}

	public Sensor(SensorPostRequest request) {
		this.id = request.getId();
		this.name = request.getName();
		this.type = request.getType();
		this.createdDate = ZonedDateTime.now();
	}

	public String getDatabaseId() {
		return databaseId;
	}

	public void setDatabaseId(String databaseId) {
		this.databaseId = databaseId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ZonedDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(ZonedDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
