package com.example.demo.exception;

@SuppressWarnings("serial")
public class CategoriaExistenteException extends Exception {
	
	private String message;

	public CategoriaExistenteException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
