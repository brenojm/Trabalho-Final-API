package com.example.demo.exception;

public class PedidoProdutoInexistenteException extends Exception {
	
	private String message;

	public PedidoProdutoInexistenteException(String message) {
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
