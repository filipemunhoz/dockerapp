package br.com.filipeapp.climate.db.service;

import java.util.Optional;

import br.com.filipeapp.climate.model.Climate;

public interface ClimateDbService {
	
	Iterable<Climate> findAll();
	
	Optional<Climate> findById(Long id);
	
	Climate save(Climate climate);
}
