package com.app.api.error;

public class MyException extends Exception {

	private static final long serialVersionUID = 111879994336254292L;

	public MyException(String errorMessage) {
		super(errorMessage);
	}

}
