package br.com.filipeapp.model.climate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Climate {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("timezone")
	private String timezone;
	
	@JsonProperty("name")
	private String city;
	
	//@JsonProperty("weather")
    //private Weather weather;
	
	@JsonProperty("main")
    private Temperature temperature;

	@JsonProperty("wind")
    private Wind wind;
	
	@JsonProperty("clouds")
    private Clouds clouds;
	

}
