package com.plantphenotypingexperiments.application.repository.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.plantphenotypingexperiments.application.entity.Accession;
import com.plantphenotypingexperiments.application.entity.Trait;
import com.plantphenotypingexperiments.application.entity.enums.ExperimentType;
import com.plantphenotypingexperiments.application.entity.Experiment;
import com.plantphenotypingexperiments.application.repository.AccessionRepository;
import com.plantphenotypingexperiments.application.repository.ExperimentRepository;
import com.plantphenotypingexperiments.application.repository.TraitRepository;

/*
 * This class generated to insert the dummy data into the H2 database at the start server 
 * 
 * @author Saidarao Boggavarapu
 * 
 */

@Component
public class ApplicationCommandLineRunner implements CommandLineRunner{
	@Autowired
	TraitRepository traitRepository;
	
	@Autowired
	AccessionRepository acceRepository;
	
	@Autowired
	ExperimentRepository expRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Trait t1 = new Trait("TRT23456","height of tree");
		Trait t2 = new Trait("TRT28457","flowering season");
		Trait t3 = new Trait("TRT87497","seed weight");
		Trait t4 = new Trait("TRT93457","leaf shape");
		List<Trait> traits = List.of(t1,t2,t3,t4);
		traitRepository.saveAll(traits);
		
		
		Accession a1 = new Accession("ACC72834","Brazilian;Lime;janu", "20200301", "USA");
		Accession a2 = new Accession("ACC90786","Indian;mango", "20210300","IND");
		List<Accession> accessions = List.of(a1,a2);
		acceRepository.saveAll(accessions);

		Experiment e1 = new Experiment("EXP356238",ExperimentType.FIELD,a1,List.of(t1,t3));		
		Experiment e2 = new Experiment("EXP896152",ExperimentType.GREENHOUSE,a1,List.of(t1,t4));
		Experiment e3 = new Experiment("EXP751682",ExperimentType.GREENHOUSE,a2,List.of(t2,t3,t4));
		List<Experiment> experiments = List.of(e1,e2,e3);
		expRepository.saveAll(experiments);

	}

}
