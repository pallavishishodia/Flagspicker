package com.org.flagpicker.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.flagpicker.dao.FlagPickerDAO;
import com.org.flagpicker.domain.CountryDomain;
import com.org.flagpicker.model.Continent;
import com.org.flagpicker.model.Country;
import com.org.flagpicker.util.JsonFileReader;

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
		return getContients();
	}

	@Override
	public List<Country> getCountryUsingContient(String continent) {

		return getCountryUsingContients(continent);
	}

	private static List<Continent> getContients() {
		List<Continent> list = new ArrayList<Continent>();
		try {

			JSONArray objArray = JsonFileReader.parseJsonFile();

			for (int i = 0; i < objArray.size(); i++) {
				Continent con = new Continent();
				JSONObject continentList = (JSONObject) objArray.get(i);
				con.setContinent(continentList.get("continent").toString());
				list.add(con);
			}

		} catch (Exception e) {

			LOGGER.error("Error in getContients method" + e);
			e.printStackTrace();
		}
		return list;
	}

	private static List<Country> getCountryUsingContients(String continent) {
		List<Country> list = new ArrayList<Country>();

		try {

			JSONArray objArray = JsonFileReader.parseJsonFile();

			for (int i = 0; i < objArray.size(); i++) {
				JSONObject continentList = (JSONObject) objArray.get(i);

				if ((continentList.get("continent").toString()).equals(continent)) {

					continentList = (JSONObject) objArray.get(i);

					JSONArray flagNameArray = (JSONArray) continentList.get("countries");

					for (int j = 0; j < flagNameArray.size(); j++) {

						JSONObject flagNameObj = (JSONObject) flagNameArray.get(j);

						Country country = new Country();
						country.setCountryFlag(flagNameObj.get("flag").toString());
						country.setCountryName(flagNameObj.get("name").toString());

						list.add(country);

					}
				}
			}

		} catch (Exception e) {
			LOGGER.error("Error in getCountry method" + e);
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String addCountryDetails(CountryDomain countryDomain) {
		try {
			FlagPickerDAO.saveCountryDetails(countryDomain);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "added Country details";
	}

}
