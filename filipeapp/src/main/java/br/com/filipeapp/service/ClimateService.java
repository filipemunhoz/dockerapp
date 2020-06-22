package br.com.filipeapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;

import br.com.filipeapp.model.climate.Climate;

@Service
public class ClimateService {
	
	private List<String> cities = new ArrayList<String>();
	
	public ClimateService() {
		
		cities.add("Atibaia");
		cities.add("Andradas");
		cities.add("Guarulhos");		
	}
	
	public List<Climate> getClimates() throws IOException {
		
		List<Climate> climates = new ArrayList<Climate>();
		
		for (String city : cities) {			
			climates.add(getClimate(city));			
		}		
		return climates;
	}

	public Climate getClimate(String city) throws IOException {

		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
			.url("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=a34fc68a89f70d121d8b5524eda79e82&lang=portuguese&units=metric&mode=json")
			.get()
			.build();

		ResponseBody response = client.newCall(request).execute().body();
		
		ObjectMapper objectMapper = new ObjectMapper(); 
		Climate climate = objectMapper.readValue(response.string(), Climate.class);
		
		return climate;
	}
}
