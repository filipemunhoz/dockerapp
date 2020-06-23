package br.com.filipeapp;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.filipeapp.climate.model.Climate;
import br.com.filipeapp.climate.service.ClimateService;

@RestController
public class GreetingController {
	
	private static final String template = "Hello, %d! \n";
	
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private ClimateService climateService;
	
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Climate> greeting() throws Exception {

		counter.incrementAndGet();
		List<Climate> climates = climateService.getClimates();

		return climates;
	}
	
	@GetMapping(value = "/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue = "world") String name) {	
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}
