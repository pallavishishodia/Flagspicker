package com.org.flagpicker.exception;

public class DaoException extends Exception {

	private static final long serialVersionUID = 8118205419370732554L;

	public DaoException(String message, Exception e) {
		super(message, e);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Exception e) {
		super(e);
	}

	public DaoException() {
		super();
	}
}
