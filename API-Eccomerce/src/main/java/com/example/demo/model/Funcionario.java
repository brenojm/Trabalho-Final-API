package com.example.demo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "funcionario")
public class Funcionario{	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcionario_id")
	private Integer idFuncionario;
	
	@Column(name = "funcionario_nome")
	private  String nome;
	
	@Column(name = "funcionario_cpf")
	private String cpf;
	
	@Column(name = "funcionario_telefone")
	private String telefone;
	
	@Column(name = "funcionario_dataNascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	//Incluir Endereço via CEP
	
	@OneToMany(mappedBy = "funcionario")
	private Set<Produto> produtos;
	
	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Funcionario() {
		super();
	}

	
	public Funcionario(Integer idFuncionario, String cpf, String telefone, Date dataNascimento, Set<Produto> produtos,
			Usuario usuario) {
		super();
		this.idFuncionario = idFuncionario;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.produtos = produtos;
		this.usuario = usuario;
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
		this.nome = nome;
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

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
	
	
}
