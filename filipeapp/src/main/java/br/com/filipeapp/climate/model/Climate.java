package br.com.filipeapp.climate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Climate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;	
	
	@JsonProperty("timezone")
	private String timezone;
	
	@JsonProperty("name")
	private String city;
	
	//@JsonProperty("weather")
//    //private Weather weather;
	
	@JsonProperty("main")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "temperature_id", referencedColumnName = "id")
    private Temperature temperature;

	@JsonProperty("wind")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "wind_id", referencedColumnName = "id")
    private Wind wind;
	
	@JsonProperty("clouds")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cloud_id", referencedColumnName = "id")
    private Cloud cloud;
	

}
