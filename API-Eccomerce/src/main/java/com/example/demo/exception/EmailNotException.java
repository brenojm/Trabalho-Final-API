package com.example.demo.exception;

@SuppressWarnings("serial")
public class EmailNotException extends Exception {
	private String message;

	public EmailNotException(String message) {
		super();
		this.message = message;
	}

	public EmailNotException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
