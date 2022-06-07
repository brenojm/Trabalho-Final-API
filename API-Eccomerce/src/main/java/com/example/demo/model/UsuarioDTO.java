package com.example.demo.model;

public class UsuarioDTO {
	
	private String email;
	
	private String username;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(String email, String senha, String username, Cliente cliente) {
		super();
		this.email = email;
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
