package com.plantphenotypingexperiments.application.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.plantphenotypingexperiments.application.entity.Trait;

/*
 * This interface generated to access data from Trait entity
 * 
 * @author Saidarao Boggavarapu
 * 
 */

@Repository
public interface TraitRepository extends CrudRepository<Trait, Integer>{
	Optional<Trait> findByTraitNumb(String traitNumb);
}
