package com.example.demo.model;

public class ProdutoDTO {
	
	private Integer id;
	
	private String nome;
	
	private Double preco;
	
	private String url;

	public ProdutoDTO(Integer id, String nome, Double preco, String url) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.url = url;
	}

	public ProdutoDTO() {
		super();
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
