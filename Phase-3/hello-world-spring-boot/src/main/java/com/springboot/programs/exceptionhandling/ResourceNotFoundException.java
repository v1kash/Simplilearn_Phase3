package com.springboot.programs.exceptionhandling;

//This Exception will be thrown by the controller when no resource i.e. employee to be returned in our case is found.

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = -9079454849611061074L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(final String message) {
		super(message);
	}

}
