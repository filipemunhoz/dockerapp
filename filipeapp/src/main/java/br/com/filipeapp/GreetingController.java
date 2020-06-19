package br.com.filipeapp;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/")
	public String greeting() throws Exception {
		
		getTemperture();
		return String.format(template, counter.getAndIncrement()) +  " " + sendGet();
	}
	
	@RequestMapping(value = "/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue = "world") String name) {
		
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	public String getTemperture() throws Exception {
		
        System.out.println("Testing 1 - Send Http GET request");
        sendGet();		
		
        return "";
	}
	
	
    private int sendGet() throws Exception {

        String url = "https://api.hgbrasil.com/weather?woeid=455827";

        HttpURLConnection httpClient =
                (HttpURLConnection) new URL(url).openConnection();

        // optional default is GET
        httpClient.setRequestMethod("GET");

        int responseCode = httpClient.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        
        return responseCode;

    }	
	

}
