package br.com.filipeapp;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.filipeapp.service.TemperatureService;

@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	TemperatureService temperatureService;
	
	@RequestMapping(value = "/")
	public String greeting() throws Exception {
		return String.format(template, counter.getAndIncrement()) +  " " + temperatureService.getLocalTemperature();
	}
	
	@RequestMapping(value = "/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue = "world") String name) {	
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}
