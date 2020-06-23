package br.com.filipeapp.climate.db.service;

import java.util.Optional;

import br.com.filipeapp.climate.model.City;

public interface CityDbService {
	
	Optional<City> findByName(String name);
	
	Iterable<City> findAll();

	City save(City city);	
}