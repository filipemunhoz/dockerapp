package br.com.filipeapp.climate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Weather {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @ManyToOne
    private Climate climate;
	
	@JsonProperty("main")
	private String main;

	@JsonProperty("description")
	private String description;

}
