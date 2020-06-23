package br.com.filipeapp.climate.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.filipeapp.climate.model.City;

public interface CityRepository extends CrudRepository<City, Long>{
	
	Optional<City> findByName(String name);

}
