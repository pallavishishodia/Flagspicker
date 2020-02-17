package com.org.flagpicker.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.org.flagpicker.model.Continent;
import com.org.flagpicker.service.FlagPickerService;

public class FlagPickerControllerTest {

	@Mock
	FlagPickerService flagPickerService;

	@InjectMocks
	FlagPickerController flagPickerController;

	@Test(expected = NullPointerException.class)
	public void testRetrieveContinentExpectiponOccour() throws Exception {
		List<Continent> list = new ArrayList<Continent>();

		Continent continent = new Continent();
		continent.setContinentId(1);
		continent.setContinent("Asia");
		list.add(continent);

		when(flagPickerService.getContinent()).thenReturn(null);

		List<Continent> listExpected = flagPickerController.retrieveContinent();

		assertNull(listExpected);

	}

	@Test(expected = NullPointerException.class)
	public void testRetrieveContinent() throws Exception {
		List<Continent> list = new ArrayList<Continent>();

		Continent continent = new Continent();
		continent.setContinentId(1);
		continent.setContinent("Asia");
		list.add(continent);

		when(flagPickerService.getContinent()).thenReturn(list);

		List<Continent> listExpected = flagPickerController.retrieveContinent();
		assertEquals(list, listExpected);

	}


}
