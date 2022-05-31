package com.example.demo.exception;

@SuppressWarnings("serial")
public class PedidoExistenteException extends Exception {
	
	private String message;
	
	public PedidoExistenteException(String message) {
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
