package com.example.demo.exception;

@SuppressWarnings("serial")
public class EnderecoInexistenteException extends Exception {

	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EnderecoInexistenteException(String message) {
		super();
		this.message = message;
	}
}
