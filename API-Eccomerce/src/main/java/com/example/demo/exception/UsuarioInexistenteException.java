package com.example.demo.exception;

@SuppressWarnings("serial")
public class UsuarioInexistenteException extends Exception{

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UsuarioInexistenteException(String message) {
		super();
		this.message = message;
	}

}
