package com.app.util;

public class ExceptionUtils {

	public static String getMessageCause(Exception e) {
		Throwable rootCause = e.getCause();
		while (rootCause.getCause() != null && rootCause.getCause() != rootCause) {
			rootCause = rootCause.getCause();
		}
		return rootCause.getMessage();
	}

}
