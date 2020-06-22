package br.com.filipeapp.climate.tasks;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.filipeapp.climate.db.service.ClimateDbService;
import br.com.filipeapp.climate.model.Climate;
import br.com.filipeapp.climate.service.ClimateService;

@Component
public class ClimateTask {

	@Autowired
	private ClimateService climateService;

	@Autowired
	private ClimateDbService climateDbService;

	
	@Scheduled(fixedRate = 60000)
	//@Scheduled(cron = "* * * * * *")
	public void get() throws IOException {
		
		List<Climate> climates = climateService.getClimates();
		for (Climate climate : climates) {
			System.out.println("#####SAVING: " + climate.getCity() + " - " + climate.getTemperature());
			
			climateDbService.save(climate);
			
		}
	}
	
}