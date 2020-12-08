package com.accenture.sats.server.exception;

public class AttendanceException extends RuntimeException {

	
	private static final long serialVersionUID = -3161586019395990827L;
	public final String NO_TIMED_IN = "Learner has not timed-in";
	public final String ALREADY_TIMED_IN = "Learner has already timed-in";
	public final String ALREADY_TIMED_OUT = "Learner already timed-out";

	public AttendanceException(String message) {
		super(message);
	}



}
