package br.com.filipeapp.climate.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;

import br.com.filipeapp.climate.db.service.CityDbService;
import br.com.filipeapp.climate.model.City;
import br.com.filipeapp.climate.model.Climate;
import br.com.filipeapp.configuration.AppConfigurationProperties;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClimateService {

	@Autowired
	private CityService cityService;

	@Autowired
	private CityDbService cityDbService;
	
	@Autowired
	private AppConfigurationProperties appConfigurationProperties;
	
	public ClimateService() {
		
	}
	
	public List<Climate> getClimates() {
		
		List<Climate> climates = new ArrayList<Climate>();
		
		cityService.initialize();
		cityDbService.findAll().forEach(city -> climates.add(getClimate(city)));
		
		return climates;
	}

	public Climate getClimate(City city) {
		
		log.info("#####Testing configuration = " + appConfigurationProperties.getDefaultHost() );

		Climate climate = null;
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
			.url("https://api.openweathermap.org/data/2.5/weather?q=" + city.getName() + "&appid=a34fc68a89f70d121d8b5524eda79e82&lang=portuguese&units=metric&mode=json")
			.get()
			.build();
		
		log.info("#####Calling API");

		try {
			ResponseBody response = client.newCall(request).execute().body();
			
			ObjectMapper objectMapper = new ObjectMapper(); 
			climate = objectMapper.readValue(response.string(), Climate.class);
			climate.setCity(city);
			
			log.info("#####Setting Response Object");
		}catch (IOException e) {
			e.printStackTrace();
		}			
		return climate;
	}
}
