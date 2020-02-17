package com.org.flagpicker.model;

public class SelectedCountry {

	private int SelectedCountryId;

	private String userId;

	private String countryName;

	private String countryFlag;

	public SelectedCountry() {
	}

	public SelectedCountry(int selectedCountryId, String userId, String countryName, String countryFlag) {

		SelectedCountryId = selectedCountryId;
		this.userId = userId;
		this.countryName = countryName;
		this.countryFlag = countryFlag;
	}

	public int getSelectedCountryId() {
		return SelectedCountryId;
	}

	public void setSelectedCountryId(int selectedCountryId) {
		SelectedCountryId = selectedCountryId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
		return "SelectedCountry [SelectedCountryId=" + SelectedCountryId + ", userId=" + userId + ", countryName="
				+ countryName + ", countryFlag=" + countryFlag + "]";
	}
}