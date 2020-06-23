package br.com.filipeapp.climate.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.filipeapp.converter.LocalDateTimeFromEpochDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sunlight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@JsonProperty("sunrise")
	@JsonDeserialize(converter = LocalDateTimeFromEpochDeserializer.class)
	private LocalDateTime sunrise;
	
	@JsonProperty("sunset")
	@JsonDeserialize(converter = LocalDateTimeFromEpochDeserializer.class)
	private LocalDateTime sunset;
	
}
