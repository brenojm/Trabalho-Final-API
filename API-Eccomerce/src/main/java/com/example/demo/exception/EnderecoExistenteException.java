package com.example.demo.exception;

@SuppressWarnings("serial")
public class EnderecoExistenteException extends Exception {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EnderecoExistenteException(String message) {
		super();
		this.message = message;
	}
	
	
}
