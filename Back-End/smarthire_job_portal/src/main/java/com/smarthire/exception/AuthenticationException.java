package com.smarthire.exception;

@SuppressWarnings("serial")
public class AuthenticationException extends RuntimeException {

	public AuthenticationException(String mesg) {
		super(mesg);
	}
}
