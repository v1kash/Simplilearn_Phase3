package com.springboot.programs.service;

//Define the EmployeeServiceException to thrown by the EmployeeService class in case of exceptionss.

public class EmployeeServiceException extends Exception {

	private static final long serialVersionUID = -470180507998010368L;

	public EmployeeServiceException() {
		super();
	}

	public EmployeeServiceException(final String message) {
		super(message);
	}
}
