package com.org.flagpicker.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.flagpicker.domain.CountryDomain;
import com.org.flagpicker.model.Continent;
import com.org.flagpicker.model.Country;
import com.org.flagpicker.service.FlagPickerService;

/**
 * This is FlagPickerController class
 * 
 * @author Pallavi Shishodia
 * @version 1.0
 **/

@RestController
@RequestMapping("/flagpicker")
public class FlagPickerController {

	private static final Logger LOGGER = LogManager.getLogger(FlagPickerController.class);
	
	@Autowired
	private FlagPickerService flagPickerService;

	@RequestMapping(value = "/continent", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Continent> retrieveContinent() throws Exception {

		return flagPickerService.getContinent();
		
	}

	@RequestMapping(value = "/country/{continent}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Country> retrieveCountry(@PathVariable(value = "continent") String continent) throws Exception {

		return flagPickerService.getCountryUsingContient(continent);
	}

	@RequestMapping(value = "/addCountry", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public String addCountryDetails(CountryDomain countryDomain) throws Exception {

		return flagPickerService.addCountryDetails(countryDomain);

	}
	
	
	
	
	
	

}