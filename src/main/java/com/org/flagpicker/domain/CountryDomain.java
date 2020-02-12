package com.org.flagpicker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class CountryDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COUNTRY_ID", unique = true, nullable = false)
	private int countryId;
	
	@Column(name = "COUNTRY_NAME")
	private String countryName;
	
	@Column(name = "COUNTRY_FLAG")
	private String countryFlag;

	public CountryDomain() {}
	
	public CountryDomain(int countryId, String countryName, String countryFlag) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.countryFlag = countryFlag;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryFlag() {
		return countryFlag;
	}

	public void setCountryFlag(String countryFlag) {
		this.countryFlag = countryFlag;
	}

	@Override
	public String toString() {
		return "CountryDomain [countryId=" + countryId + ", countryName=" + countryName + ", countryFlag=" + countryFlag
				+ "]";
	}
}