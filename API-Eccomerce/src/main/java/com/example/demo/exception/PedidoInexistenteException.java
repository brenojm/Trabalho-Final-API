package com.example.demo.exception;

@SuppressWarnings("serial")
public class PedidoInexistenteException extends Exception {
	
private String message;
	
	public PedidoInexistenteException(String message) {
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
