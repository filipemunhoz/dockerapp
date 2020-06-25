package br.com.filipeapp.climate.model;

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
public class Temperature {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;	
	
//	colocar id_cidade
//	colocar data/hora
	
    @JsonProperty("temp")
    private Integer degrees;
    
    @JsonProperty("feels_like")
    private Integer feelsLike;
    
    @JsonProperty("temp_min")
    private Integer minimal;
    
    @JsonProperty("temp_max")
    private Integer maximum;
    
    @JsonProperty("pressure")
    private Integer pressure;
    
    @JsonProperty("humidity")
    private Integer humidity;
    
    @JsonProperty("sea_level")
    private Double seaLevel;
    
    @JsonProperty("grnd_level")
    private Double groundLevel;


}
