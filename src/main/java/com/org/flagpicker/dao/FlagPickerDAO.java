package com.org.flagpicker.dao;

import java.util.List;

import com.org.flagpicker.domain.CountryDomain;
import com.org.flagpicker.domain.SelectedCountryDomain;
import com.org.flagpicker.exception.DaoException;

public interface FlagPickerDAO {

	public void saveCountryDetails(final CountryDomain countryDomain) throws DaoException;
	public void userSelectedCountry(List<SelectedCountryDomain> list) throws DaoException;
}
