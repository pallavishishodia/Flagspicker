package com.org.flagpicker.dao;

import com.org.flagpicker.domain.CountryDomain;
import com.org.flagpicker.exception.DaoException;

public interface FlagPickerDAO {

	public void saveCountryDetails(final CountryDomain countryDomain) throws DaoException;
	
}
