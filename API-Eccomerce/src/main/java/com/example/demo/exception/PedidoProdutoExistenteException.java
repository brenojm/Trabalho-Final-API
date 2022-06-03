package com.example.demo.exception;

@SuppressWarnings("serial")
public class PedidoProdutoExistenteException extends Exception {
	
	private String message;

	public PedidoProdutoExistenteException(String message) {
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
