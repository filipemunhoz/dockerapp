package br.com.filipeapp.climate.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Wind {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;	
	
	@JsonProperty("speed")
	private BigDecimal speed;
	
	@JsonProperty("deg")
	private Integer degrees;
	
}
