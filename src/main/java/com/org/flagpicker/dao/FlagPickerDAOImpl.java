package com.org.flagpicker.dao;

import javax.persistence.PersistenceException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.org.flagpicker.domain.CountryDomain;
import com.org.flagpicker.exception.DaoException;
import com.org.flagpicker.util.AbstactDao;

@Repository
public class FlagPickerDAOImpl extends AbstactDao<CountryDomain> implements FlagPickerDAO {
	private static final Logger LOGGER = LogManager.getLogger(FlagPickerDAOImpl.class);

	@Override
	public void saveCountryDetails(CountryDomain countryDomain) throws DaoException {
		try {
			getSession().save(countryDomain);
		} catch (HibernateException | PersistenceException ex) {
			ex.printStackTrace();
			LOGGER.error("error while saving country details" + ex);
			throw new DaoException("error while saving country details" + ex);
		}
	}
}