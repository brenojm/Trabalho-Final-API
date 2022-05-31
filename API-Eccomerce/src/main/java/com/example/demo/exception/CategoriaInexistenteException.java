package com.example.demo.exception;

public class CategoriaInexistenteException extends Exception {
private String message;
	
	public CategoriaInexistenteException(String message) {
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
