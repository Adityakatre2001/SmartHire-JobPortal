package com.smarthire.exception;

public class InvalidCredentialsException extends RuntimeException {

	public InvalidCredentialsException(String mesg) {
		super(mesg);
	}
}
