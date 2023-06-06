package com.plantphenotypingexperiments.application.entity;

import java.util.List;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

/*
 * This class holds information regarding trait of the experiment
 * 
 * @author Saidarao Boggavarapu
 * 
 */

@Entity
@Table(name = "trait")
public class Trait {
	@Id
	@Size(min = 8, max =8, message = "Trait number 8 character long text contain alphabets and numbers, ex: 'TRT12345'")
	@Column(name = "traitNumb", nullable = false, unique = true, updatable = false)
   	String traitNumb;
	
	@Column(name = "traitName", nullable = false, unique = true)
	String traitName;
	
	@ManyToMany(mappedBy = "traits")
	@JsonIgnore
	List<Experiment> experiments;

	public Trait() {
		super();
	}

	
	public Trait(String traitNumb, String traitName) throws Exception {
		super();
		this.traitNumb = validateTraitNumb(traitNumb);
		this.traitName = traitName;
	}


	public Trait(String traitNumb, String traitName, List<Experiment> experiments) throws Exception {
		super();
		this.traitNumb = validateTraitNumb(traitNumb);
		this.traitName = traitName;
		this.experiments = experiments;
	}

	public String getTraitNumb() {
		return traitNumb;
	}

	public void setTraitNumb(String traitNumb) throws Exception {
		this.traitNumb = validateTraitNumb(traitNumb);
	}

	public String getTraitName() {
		return traitName;
	}

	public void setTraitName(String traitName) {
		this.traitName = traitName;
	}

	public List<Experiment> getExperiments() {
		return experiments;
	}

	public void setExperiments(List<Experiment> experiments) {
		this.experiments = experiments;
	}
	
	private String validateTraitNumb(String numb) throws Exception{
		Pattern pattern=Pattern.compile("[a-zA-Z]{3}[0-9]{5}");
		if(pattern.matcher(numb).matches()){
			return numb;
		}
		else {
			throw new Exception("Trait number not in required format, ex: 'TRT12345'");
		}
	}

	@Override
	public String toString() {
		return "Trait [traitNumb=" + traitNumb + ", traitName=" + traitName + ", experiments=" + experiments + "]";
	}
	
}
