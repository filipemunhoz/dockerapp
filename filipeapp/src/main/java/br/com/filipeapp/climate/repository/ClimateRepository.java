package br.com.filipeapp.climate.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.filipeapp.climate.model.Climate;

public interface ClimateRepository extends CrudRepository<Climate, Long>{

}
