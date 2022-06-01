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
public class Funcionario{	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcionario_id")
	private Integer idFuncionario;
	
	@Column(name = "funcionario_nome")
	private static String nome;
	
	@Column(name = "funcionario_cpf")
	private String cpf;
	
	@Column(name = "funcionario_telefone")
	private String telefone;
	
	@Column(name = "funcionario_dataNascimento")
	private Date dataNascimento;
	
	//Incluir Endereço via CEP

	public Funcionario() {
		super();
	}

	public Funcionario(Integer idUsuario, String email, String userName, String senha, char role, Integer idFuncionario,
			String cpf, String telefone, Date dataNascimento) {
		super();
		this.idFuncionario = idFuncionario;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
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
}
