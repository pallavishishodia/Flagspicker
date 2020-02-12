package com.org.flagpicker.model;

public class Continent {

	private int continentId;
	private String continent;

	public Continent() {
	}

	public Continent(int continentId, String continent) {
		super();
		this.continentId = continentId;
		this.continent = continent;
	}

	public int getContinentId() {
		return continentId;
	}

	public void setContinentId(int continentId) {
		this.continentId = continentId;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

}