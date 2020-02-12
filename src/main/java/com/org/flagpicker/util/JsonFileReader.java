package com.org.flagpicker.util;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public final class JsonFileReader {

	public static JSONArray parseJsonFile() {

		JSONArray objArray =  new JSONArray();
		try {

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("src/main/resources/continents.json"));
			 objArray = (JSONArray) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return objArray;
	}
}
