package com.example.demo.exception;

public class ProdutoExistenteException extends Exception {
	
	private String message;
	
	public ProdutoExistenteException(String message) {
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
