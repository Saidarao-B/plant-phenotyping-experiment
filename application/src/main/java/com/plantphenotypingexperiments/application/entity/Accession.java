package com.plantphenotypingexperiments.application.entity;

import java.util.List;
import java.util.regex.Pattern;

import com.neovisionaries.i18n.CountryCode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

/*
 * This class holds information regarding Accession of the experiment
 * 
 * @author Saidarao Boggavarapu
 * 
 */

@Entity
@Table(name = "accession")
public class Accession {
	@Id
	@Size(min = 8, max = 8, message = "Accession number 8 character long text contain alphabets and numbers, ex: 'ACC12345' or 'PI123456'")
	@Column(name = "acceNumb", nullable = false, unique = true, updatable = false)
	String acceNumb;
	
	@Column(name = "accession_name", nullable = false, unique = false)
	String acceName;
	
	@Column(name = "acquisition_date", nullable = false, unique = false)
	String acqDate;
	
	@Column(name = "origin_country", nullable = false, unique = false)
	CountryCode origCty;
	
	@OneToMany(mappedBy = "accession", cascade = CascadeType.ALL)
    List<Experiment> experiments;

	public Accession() {
		super();
	}
	
	public Accession(String acceNumb, String acceName, String acqDate, String origCty) throws Exception {
		super();
		this.acceNumb = validateAcceNumb(acceNumb);
		this.acceName = toAccessionName(acceName);
		this.acqDate = validateAcqDate(acqDate);
		this.origCty = CountryCode.getByAlpha3Code(validateCountryCode(origCty));
	}

	public Accession(String acceNumb, String acceName, String acqDate, String origCty, List<Experiment> experiments) throws Exception {
		super();
		this.acceNumb = validateAcceNumb(acceNumb);
		this.acceName = toAccessionName(acceName);
		this.acqDate = validateAcqDate(acqDate);
		this.origCty = CountryCode.getByAlpha3Code(validateCountryCode(origCty));
		this.experiments = experiments;
	}

	public String getAcceNumb() {
		return acceNumb;
	}

	public void setAcceNumb(String acceNumb) throws Exception {
		this.acceNumb = validateAcceNumb(acceNumb);
	}

	public String getAcceName() {
		return acceName;
	}

	public void setAcceName(String acceName) throws Exception {
		this.acceName = toAccessionName(acceName);
	}

	public String getAcqDate() {
		return acqDate;
	}

	public void setAcqDate(String acqDate) throws Exception {
		this.acqDate = validateAcqDate(acqDate);
	}

	public String getOrigCty() {
		return origCty.getAlpha3();
	}

	public void setOrigCty(String origCty) throws Exception {
		this.origCty = CountryCode.getByAlpha3Code(validateCountryCode(origCty));
	}

	public List<Experiment> getExperiments() {
		return experiments;
	}

	public void setExperiments(List<Experiment> experiments) {
		this.experiments = experiments;
	}
	
	private String toAccessionName(String accName) throws Exception {
		String res = accName;
		if(accName.isBlank()) {
			throw new Exception("Accession name should not be empty");
		}
		else {
			String[] names = accName.replaceAll("\\s", "").split("(?<=;)");
			res = "";
			for(String name: names) {
				name.trim();
				res += name.substring(0, 1).toUpperCase()+name.substring(1);
			}
		}
		return res;
	}
	
	private String validateCountryCode(String code) throws Exception {
		if(code.length()!=3) {
			throw new Exception("Country code should have only three characters");
		}
		code.toUpperCase();
		return code;
		
	}

	private String validateAcceNumb(String numb) throws Exception{
		Pattern pattern1 = Pattern.compile("[a-zA-Z]{3}[0-9]{5}");
		Pattern pattern2 = Pattern.compile("[a-zA-Z]{2}[0-9]{6}");
		if(pattern1.matcher(numb).matches() || pattern2.matcher(numb).matches()){
			return numb;
		}
		else {
			throw new Exception("Accession number not in required format, ex: 'ACC12345' or 'PI123456'");
		}
	}
	
	private String validateAcqDate(String date) throws Exception {
		Pattern pattern = Pattern.compile("[0-9]{4}(0[0-9]|1[012])(0[0-9]|[12][0-9]|3[01])");
		if(pattern.matcher(date).matches()){
			return date;
		}
		else {
			throw new Exception("Aquisition date not in required format, ex: date format(YYYYMMDD) '20221231' or '20220000'");
		}
		 
	}
	
	@Override
	public String toString() {
		return "Accession [acceNumb=" + acceNumb + ", acceName=" + acceName + ", acqDate=" + acqDate + ", origCty="
				+ origCty + ", experiments=" + experiments + "]";
	}

}