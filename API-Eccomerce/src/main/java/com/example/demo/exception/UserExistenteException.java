package com.example.demo.exception;

@SuppressWarnings("serial")
public class UserExistenteException extends Exception {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserExistenteException(String message) {
		super();
		this.message = message;
	}
}
