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

import com.plantphenotypingexperiments.application.entity.Experiment;
import com.plantphenotypingexperiments.application.repository.ExperimentRepository;

import jakarta.validation.Valid;

/*
 * This class holds REST endpoints for Experiment
 * 
 * @author Saidarao Boggavarapu
 * 
 */

@RestController
@RequestMapping("/experiment/")
public class ExperimentController {
	@Autowired
	ExperimentRepository repository;
	
	@RequestMapping(path = "/put", method = RequestMethod.POST)
	ResponseEntity<Object> createExperiment(@Valid @RequestBody(required = true) Experiment experiment) {
		repository.save(experiment);
		return new ResponseEntity<>("Experiment record inserted", HttpStatus.OK);
	}
	
	@RequestMapping(path = "/get/{expNumb}", method = RequestMethod.GET)
	ResponseEntity<Object> getExperimentById(@PathVariable String expNumb) {
		Optional<Experiment> experiment = repository.findByExpNumb(expNumb);
		return new ResponseEntity<>(experiment, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/get/all", method = RequestMethod.GET)
	ResponseEntity<Object> getAllExperiments() {
		Iterable<Experiment> experiments= repository.findAll();
		return new ResponseEntity<>(experiments, HttpStatus.OK);
	}
	
}
