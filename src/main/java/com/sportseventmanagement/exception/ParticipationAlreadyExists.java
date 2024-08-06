package com.sportseventmanagement.exception;

public class ParticipationAlreadyExists extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public ParticipationAlreadyExists() {
		super();
	}
	
	public ParticipationAlreadyExists(String message) {
		super(message);
	}

}
