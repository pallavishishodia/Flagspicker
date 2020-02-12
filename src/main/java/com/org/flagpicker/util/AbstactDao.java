package com.org.flagpicker.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

public abstract class AbstactDao<T> {

	@PersistenceContext
	protected transient EntityManager entityManager;

	public Object save(final T toSave) {

		return entityManager.unwrap(Session.class).save(toSave);
	}

	protected Session getSession() {
		return entityManager.unwrap(Session.class);
	}
}
