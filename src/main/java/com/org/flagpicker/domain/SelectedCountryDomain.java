package com.org.flagpicker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SELECTED_COUNTRY")
public class SelectedCountryDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COUNTRY_ID", unique = true, nullable = false)
	private int SelectedCountryId;

	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "COUNTRY_NAME")
	private String countryName;

	@Column(name = "COUNTRY_FLAG")
	private String countryFlag;

	public SelectedCountryDomain() {
	}

	public SelectedCountryDomain(int selectedCountryId, String userId, String countryName, String countryFlag) {

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
		return "SelectedCountryDomain [SelectedCountryId=" + SelectedCountryId + ", userId=" + userId + ", countryName="
				+ countryName + ", countryFlag=" + countryFlag + "]";
	}
}