package com.org.flagpicker.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.flagpicker.dao.FlagPickerDAO;
import com.org.flagpicker.domain.CountryDomain;
import com.org.flagpicker.domain.SelectedCountryDomain;
import com.org.flagpicker.model.Continent;
import com.org.flagpicker.model.Country;
import com.org.flagpicker.util.FlagPickerParser;

/**
 * FlagPickerService class is use for loading json for continent and Country
 * 
 * @author Pallavi Shishodia
 * @version 1.0
 **/
@Service
public class FlagPickerServiceImpl implements FlagPickerService {

	private static final Logger LOGGER = LogManager.getLogger(FlagPickerServiceImpl.class);

	@Autowired
	FlagPickerDAO FlagPickerDAO;

	@Override
	public List<Continent> getContinent() {
		FlagPickerParser parser = new FlagPickerParser();

		return parser.parseContientsJson();
	}

	@Override
	public List<Country> getCountryUsingContient(String continent) {
		FlagPickerParser parser = new FlagPickerParser();

		return parser.parseCountryDetailsJson(continent);
	}
	
	@Override
	public String selectedCountryDeatils(List<SelectedCountryDomain> list) throws Exception {

		try {

			FlagPickerDAO.userSelectedCountry(list);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in SelectedCountryDeatils method" + e);
		}

		return "added selected Country details";
	}

	@Override
	public String addCountryDetails(CountryDomain countryDomain) {
		try {
			FlagPickerDAO.saveCountryDetails(countryDomain);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in addCountryDetails method" + e);
		}
		return "added Country details";
	}

	

}
