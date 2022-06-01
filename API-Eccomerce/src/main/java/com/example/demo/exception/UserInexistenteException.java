package com.example.demo.exception;

@SuppressWarnings("serial")
public class UserInexistenteException extends Exception{

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserInexistenteException(String message) {
		super();
		this.message = message;
	}

}
