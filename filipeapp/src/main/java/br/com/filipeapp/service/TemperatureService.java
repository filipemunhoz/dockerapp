package br.com.filipeapp.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;

import br.com.filipeapp.Temperature;

@Service
public class TemperatureService {

	public String getLocalTemperature() throws IOException {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
			.url("https://api.openweathermap.org/data/2.5/weather?q=Sao%20Paulo&appid=a34fc68a89f70d121d8b5524eda79e82&lang=portuguese&units=metric&mode=json")
			.get()
			.build();

		ResponseBody response = client.newCall(request).execute().body();
		
		ObjectMapper objectMapper = new ObjectMapper(); 
		Temperature temperature = objectMapper.readValue(response.string(), Temperature.class);
		
		return temperature.getTemperatureMain().getTemperature();
	}
}
