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
public class Temperature {
	
    @JsonProperty("temp")
    private Double degrees;
    
    @JsonProperty("feels_like")
    private Double feelsLike;
    
    @JsonProperty("temp_min")
    private Double minimal;
    
    @JsonProperty("temp_max")
    private Double maximum;
    
    @JsonProperty("pressure")
    private Double pressure;
    
    @JsonProperty("humidity")
    private Double humidity;
    
    @JsonProperty("sea_level")
    private Double seaLevel;
    
    @JsonProperty("grnd_level")
    private Double groundLevel;


}
