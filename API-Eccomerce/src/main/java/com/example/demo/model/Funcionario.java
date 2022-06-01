package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "funcionario")
public class Funcionario {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcionario_id")
	private Integer idFuncionario;
	
	@Column(name = "funcionario_nome")
	private static String nome;
	
	@Column(name = "funcionario_cpf")
	private String cpf;
	
	@Column(name = "funcionario_email")
	private String email;
	
	@Column(name = "funcionario_userName")
	private String userName;
	
	@Column(name = "funcionario_senha")
	private String senha;
	
	@Column(name = "funcionario_telefone")
	private String telefone;
	
	@Column(name = "funcionario_dataNascimento")
	private Date dataNascimento;
	
	//Incluir Endereço via CEP

	public Funcionario() {
		super();
	}

	public Funcionario(Integer idFuncionario, String nome, String cpf, String email, String userName, String senha, String telefone, Date dataNascimento) {
		super();
		this.idFuncionario = idFuncionario;
		Funcionario.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.userName = userName;
		this.senha = senha;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public static String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		Funcionario.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
