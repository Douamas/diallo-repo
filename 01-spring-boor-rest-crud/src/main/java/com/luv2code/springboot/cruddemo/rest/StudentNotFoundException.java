package com.luv2code.springboot.cruddemo.rest;

public class StudentNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 66642788561073284L;

	public StudentNotFoundException() {
		super();
	}


	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}
