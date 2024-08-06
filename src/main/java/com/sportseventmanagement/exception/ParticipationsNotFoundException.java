package com.sportseventmanagement.exception;

public class ParticipationsNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public ParticipationsNotFoundException() {
		super();
	}
	
	public ParticipationsNotFoundException(String message) {
		super(message);
	}
}
