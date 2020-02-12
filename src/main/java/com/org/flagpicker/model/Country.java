package com.org.flagpicker.model;

public class Country {

	private int countryId;
	private String countryName;
	private String countryFlag;

	public Country() {}
	
	public Country(int countryId, String countryName, String countryFlag) {
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
}