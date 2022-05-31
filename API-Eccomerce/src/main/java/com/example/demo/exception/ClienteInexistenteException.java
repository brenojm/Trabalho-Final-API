package com.example.demo.exception;

public class ClienteInexistenteException extends Exception{

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ClienteInexistenteException(String message) {
		super();
		this.message = message;
	}

	public ClienteInexistenteException() {
		super();
	}
	
}