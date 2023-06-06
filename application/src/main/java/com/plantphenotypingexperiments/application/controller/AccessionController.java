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

import com.plantphenotypingexperiments.application.entity.Accession;
import com.plantphenotypingexperiments.application.repository.AccessionRepository;

import jakarta.validation.Valid;

/*
 * This class holds REST endpoints for Accession
 * 
 * @author Saidarao Boggavarapu
 * 
 */

@RestController
@RequestMapping("/accession/")
public class AccessionController {
	@Autowired
	AccessionRepository repository;
	
	@RequestMapping(path = "/put", method = RequestMethod.POST)
	ResponseEntity<Object> createAccession(@Valid @RequestBody(required = true) Accession accession) {
		repository.save(accession);
		return new ResponseEntity<>("Accession record inserted", HttpStatus.OK);
	}
	
	@RequestMapping(path = "/get/{acceNumb}", method = RequestMethod.GET)
	ResponseEntity<Object> getAccessionById(@PathVariable String acceNumb) {
		Optional<Accession> accession = repository.findByAcceNumb(acceNumb);
		return new ResponseEntity<>(accession, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/get/all", method = RequestMethod.GET)
	ResponseEntity<Object> getAllAccessions() {
		Iterable<Accession> accessions = repository.findAll();
		return new ResponseEntity<>(accessions, HttpStatus.OK);
	}
}
