package application.models.entity.response;

import java.util.List;

import application.models.entity.SensorData;

public class SensorDataList {

	private List<SensorData> sensorData;

	public SensorDataList() {
	}

	public SensorDataList(List<SensorData> sensorData) {
		this.sensorData = sensorData;
	}

	public List<SensorData> getSensorData() {
		return sensorData;
	}

	public void setSensorData(List<SensorData> sensorData) {
		this.sensorData = sensorData;
	}
}
