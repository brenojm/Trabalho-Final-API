package com.example.demo.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String nome;
	
	private String descricao;
	
	private Double preco;
	
	private Integer quatidadeEstoque;
	
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	// imagem
	
	public Produto() {
		super();
	}
	public Produto(Integer id, String nome, String descricao, Double preco, Integer quatidadeEstoque,
			Date dataCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quatidadeEstoque = quatidadeEstoque;
		this.dataCadastro = dataCadastro;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Integer getQuatidadeEstoque() {
		return quatidadeEstoque;
	}
	public void setQuatidadeEstoque(Integer quatidadeEstoque) {
		this.quatidadeEstoque = quatidadeEstoque;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	
	
}
