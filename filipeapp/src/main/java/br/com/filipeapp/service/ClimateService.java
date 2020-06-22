package br.com.filipeapp.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import br.com.filipeapp.climate.model.Climate;

public interface ClimateService {
	
	Iterable<Climate> findAll();
	
	List<Climate> getClimates() throws IOException;
	
	Optional<Climate> findById(Long id);

}
