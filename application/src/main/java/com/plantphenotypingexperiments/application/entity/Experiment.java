package com.plantphenotypingexperiments.application.entity;

import java.util.List;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plantphenotypingexperiments.application.entity.enums.ExperimentType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

/*
 * This class holds information regarding Experiment details
 * 
 * @author Saidarao Boggavarapu
 * 
 */

@Entity
@Table(name = "experiment")
public class Experiment {
	@Id
	@Size(min = 9, max = 9, message = "Experiment number 8 character long text contain alphabets and numbers, ex: 'EXP123456'")
	@Column(name = "expNumb", nullable = false, unique = true, updatable = false)
	String expNumb; 
	
	@Column(nullable = false,  name = "expType")
    @Enumerated(EnumType.STRING)
	ExperimentType expType;
	
	@JoinColumn(name = "acceNumb")
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
    Accession accession;
    
	@ManyToMany
	@JoinTable(
			  name = "experiments_traits", 
			  joinColumns = @JoinColumn(name = "expNumb"), 
			  inverseJoinColumns = @JoinColumn(name = "traitNumb"))	
    List<Trait> traits;

	public Experiment() {
		super();
	}

	public Experiment(String expNumb, ExperimentType expType, Accession accession, List<Trait> traits) throws Exception {
		super();
		this.expNumb = validateExpNumb(expNumb);
		this.expType = expType;
		this.accession = accession;
		this.traits = traits;
	}

	public String getExpNumb() {
		return expNumb;
	}

	public void setExpNumb(String expNumb) throws Exception {
		this.expNumb = validateExpNumb(expNumb);
	}

	public ExperimentType getExpType() {
		return expType;
	}

	public void setExpType(ExperimentType expType) {
		this.expType = expType;
	}

	public Accession getAccession() {
		return accession;
	}

	public void setAccession(Accession accession) {
		this.accession = accession;
	}

	public List<Trait> getTraits() {
		return traits;
	}

	public void setTraits(List<Trait> traits) {
		this.traits = traits;
	}
	
	private String validateExpNumb(String numb) throws Exception{
		Pattern pattern = Pattern.compile("[a-zA-Z]{3}[0-9]{6}");
		if(pattern.matcher(numb).matches()){
			return numb;
		}
		else {
			throw new Exception("Experiment number not in required format, ex: 'EXP123456'");
		}
	}

	@Override
	public String toString() {
		return "Experiment [expNumb=" + expNumb + ", expType=" + expType + ", accession=" + accession + ", traits="
				+ traits + "]";
	}
	
}
