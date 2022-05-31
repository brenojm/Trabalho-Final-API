package com.example.demo.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	private String email;
	private String userName;
	private String senha;
	private String nome;
	private String cpf;
	private Integer telefone;
	
	@OneToMany(mappedBy="cliente")
    private String id_endereco;
    
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    
	public Cliente(Long id, String email, String userName, String senha, String nome, String cpf, Integer telefone,
			String endereco,Date dataNascimento) {
		super();
		Id = id;
		this.email = email;
		this.userName = userName;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.id_endereco = endereco;
		this.dataNascimento=dataNascimento;
	}

	public Cliente() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public String getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(String id_endereco) {
		this.id_endereco = id_endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	    
}


