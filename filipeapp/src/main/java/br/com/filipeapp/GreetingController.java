package br.com.filipeapp;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.filipeapp.model.climate.Climate;
import br.com.filipeapp.service.ClimateService;

@RestController
public class GreetingController {
	
	private static final String template = "Hello, %d! \n";
	
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	ClimateService climateService;
	
	
	@RequestMapping(value = "/")
	public String greeting() throws Exception {
		
		StringBuilder s = new StringBuilder();
		
		List<Climate> climates = climateService.getClimates();
		for (Climate climate : climates) {
			
			s.append(System.getProperty("line.separator"));
			s.append("City: ");
			s.append(climate.getCity());
			s.append(System.getProperty("line.separator"));
			s.append("Temperature: ");
			s.append(climate.getTemperature().getDegrees());
			s.append(System.getProperty("line.separator"));			
		}
		

		
		return String.format(template, counter.getAndIncrement()) +  " " + s.toString();
	}
	
	@RequestMapping(value = "/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue = "world") String name) {	
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}
