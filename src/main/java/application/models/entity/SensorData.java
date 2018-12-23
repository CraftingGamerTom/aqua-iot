package application.models.entity;

import java.time.ZonedDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import application.services.json.serializers.JsonDateSerializer;;

public class SensorData {

	@JsonIgnore
	private String databaseId;
	private String id;
	private double value;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	@JsonSerialize(using = JsonDateSerializer.class)
	private ZonedDateTime measureDate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	@JsonSerialize(using = JsonDateSerializer.class)
	private ZonedDateTime ingestionDate;

	public SensorData() {
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public ZonedDateTime getIngestionDate() {
		return ingestionDate;
	}

	public void setIngestionDate(ZonedDateTime ingestionDate) {
		this.ingestionDate = ingestionDate;
	}

	public ZonedDateTime getMeasureDate() {
		return measureDate;
	}

	public void setMeasureDate(ZonedDateTime measureDate) {
		this.measureDate = measureDate;
	}

}
