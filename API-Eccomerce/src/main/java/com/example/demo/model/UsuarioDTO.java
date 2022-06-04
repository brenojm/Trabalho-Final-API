package com.example.demo.model;

public class UsuarioDTO {
	
	private String email;
	
	private String senha;
	
	private String username;
	
	private Cliente cliente;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(String email, String senha, String username, Cliente cliente) {
		super();
		this.email = email;
		this.senha = senha;
		this.username = username;
		this.cliente = cliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
