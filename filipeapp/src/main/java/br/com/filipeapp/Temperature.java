package br.com.filipeapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
	
	@JsonProperty("main")
    private TemperatureMain temperatureMain;

	public TemperatureMain getTemperatureMain() {
		return temperatureMain;
	}

	public void setTemperatureMain(TemperatureMain temperatureMain) {
		this.temperatureMain = temperatureMain;
	}
}
