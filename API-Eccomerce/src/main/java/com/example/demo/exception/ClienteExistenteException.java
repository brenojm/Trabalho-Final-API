package com.example.demo.exception;

@SuppressWarnings("serial")
public class ClienteExistenteException extends Exception{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ClienteExistenteException(String message) {
		super();
		this.message = message;
	}

	public ClienteExistenteException() {
		super();
	}
	
	

}
