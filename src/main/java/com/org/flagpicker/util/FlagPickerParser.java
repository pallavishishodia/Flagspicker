package com.org.flagpicker.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.org.flagpicker.domain.SelectedCountryDomain;
import com.org.flagpicker.model.Continent;
import com.org.flagpicker.model.Country;

public class FlagPickerParser {

	private static final Logger LOGGER = LogManager.getLogger(FlagPickerParser.class);

	public List<Continent> parseContientsJson() {

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

	public List<Country> parseCountryDetailsJson(String continent) {

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

	public static List<SelectedCountryDomain> parseSelectedCountryJson(String json, String userId) {

		List<SelectedCountryDomain> list = new ArrayList<SelectedCountryDomain>();
		try {

			JSONParser parser = new JSONParser();
			Object continentList = parser.parse(json);

			JSONObject jsonlist = (JSONObject) continentList;

			JSONArray flagNameArray = (JSONArray) jsonlist.get("countries");

			for (int j = 0; j < flagNameArray.size(); j++) {

				JSONObject flagNameObj = (JSONObject) flagNameArray.get(j);

				SelectedCountryDomain country = new SelectedCountryDomain();

				country.setUserId(userId);
				country.setCountryFlag(flagNameObj.get("flag").toString());
				country.setCountryName(flagNameObj.get("name").toString());

				list.add(country);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

}