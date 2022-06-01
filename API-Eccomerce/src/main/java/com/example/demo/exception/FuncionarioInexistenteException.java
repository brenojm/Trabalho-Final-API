package com.example.demo.exception;

public class FuncionarioInexistenteException extends Exception {
	
	private String message;

	public FuncionarioInexistenteException(String message) {
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
