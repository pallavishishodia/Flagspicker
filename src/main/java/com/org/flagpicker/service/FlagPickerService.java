package com.org.flagpicker.service;

import java.util.List;

import com.org.flagpicker.domain.CountryDomain;
import com.org.flagpicker.model.Continent;
import com.org.flagpicker.model.Country;

public interface FlagPickerService {

	public List<Continent> getContinent() throws Exception;
	
	public List<Country> getCountryUsingContient(String continent) throws Exception;
	
	public String addCountryDetails(CountryDomain countryDomain) throws Exception;
	
}
