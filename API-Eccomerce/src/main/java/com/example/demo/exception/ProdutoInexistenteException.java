package com.example.demo.exception;

public class ProdutoInexistenteException extends Exception {
	
	private String message;

	public ProdutoInexistenteException(String message) {
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
