package com.example.demo.exception;

@SuppressWarnings("serial")
public class FuncionarioExistenteException extends Exception {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public FuncionarioExistenteException(String message) {
		super();
		this.message = message;
	}

	public FuncionarioExistenteException() {
		super();
	}

}
