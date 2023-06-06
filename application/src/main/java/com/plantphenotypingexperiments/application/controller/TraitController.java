package com.plantphenotypingexperiments.application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.plantphenotypingexperiments.application.entity.Trait;
import com.plantphenotypingexperiments.application.repository.TraitRepository;

import jakarta.validation.Valid;

/*
 * This class holds REST endpoints for Trait
 * 
 * @author Saidarao Boggavarapu
 * 
 */

@RestController
@RequestMapping("/trait/")
public class TraitController {
	@Autowired 
	TraitRepository repository;
	
	@RequestMapping(path = "/put", method = RequestMethod.POST)
	ResponseEntity<Object> createTrait(@Valid @RequestBody(required = true) Trait trait) {
		repository.save(trait);
		return new ResponseEntity<>("Trait record inserted", HttpStatus.OK);
	}
	
	@RequestMapping(path = "/get/{traitNumb}", method = RequestMethod.GET)
	ResponseEntity<Object> getTraitById(@PathVariable String traitNumb) {
		Optional<Trait> trait = repository.findByTraitNumb(traitNumb);
		return new ResponseEntity<>(trait, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/get/all", method = RequestMethod.GET)
	ResponseEntity<Object> getAllTraits() {
		Iterable<Trait> traits = repository.findAll();
		return new ResponseEntity<>(traits, HttpStatus.OK);
	}
	
}
