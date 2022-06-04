package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	
	private String email;
	
	private String senha;
	
	private String username;
	
	private String role;
	
	@JsonIgnore
	@OneToOne(mappedBy = "usuario")
	private Cliente cliente;
	
	@OneToOne(mappedBy = "usuario")
	private Funcionario funcionario;

	public Usuario() {
		super();
	}

	public Usuario(Integer idUsuario, String email, String senha, String username, String role, Cliente cliente, 
			Funcionario funcionario) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.senha = senha;
		this.username = username;
		this.role = role;
		this.cliente = cliente;
		this.funcionario = funcionario;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
