package br.com.filipeapp.climate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.filipeapp.climate.db.service.CityDbService;
import br.com.filipeapp.climate.model.City;


@Service
public class CityService {
	
	@Autowired
	private CityDbService cityDbService;
	
	private List<City> cities = List.of(
									new City("Atibaia"),
									new City("Andradas"),									
									new City("Extrema"),
									new City("Torrinha"),
									new City("Governador Valadares"),
									new City("Guarulhos")
								);
	
	public void initialize() {		
		
		cities.forEach(c -> cityDbService.findByName(c.getName())				
						.ifPresentOrElse((a) -> {}, () -> cityDbService.save(c)));
	}
}
