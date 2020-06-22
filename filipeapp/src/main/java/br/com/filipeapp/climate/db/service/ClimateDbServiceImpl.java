package br.com.filipeapp.climate.db.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.filipeapp.climate.exception.ClimateNotFoundException;
import br.com.filipeapp.climate.model.Climate;
import br.com.filipeapp.climate.repository.ClimateRepository;

@Service
public class ClimateDbServiceImpl implements ClimateDbService{
	
	@Autowired
	private ClimateRepository repository;

	@Override
	public Climate save(Climate climate) {
		return repository.save(climate);
	}	
	
	@Override
	public Iterable<Climate> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Optional<Climate> findById(Long id) {
		return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ClimateNotFoundException(id)));
	}
}
