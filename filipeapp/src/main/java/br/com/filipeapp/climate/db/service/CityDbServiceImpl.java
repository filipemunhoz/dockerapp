package br.com.filipeapp.climate.db.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.filipeapp.climate.model.City;
import br.com.filipeapp.climate.repository.CityRepository;

@Service
public class CityDbServiceImpl implements CityDbService{

	@Autowired
	private CityRepository repository;

	@Override
	public Iterable<City> findAll() {
		return repository.findAll();
	}
	
	@Override
	public City save(City city) {
		return repository.save(city);
	}

	@Override
	public Optional<City> findByName(String name) {
		return repository.findByName(name);
	}		
}
