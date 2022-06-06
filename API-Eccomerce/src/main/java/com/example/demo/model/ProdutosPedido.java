package com.example.demo.model;

public class ProdutosPedido {
	
	private Integer idProduto;
	
	private String nome;
	
	private Integer quantidade;

	public ProdutosPedido(Integer idProduto, Integer quantidade, String nome) {
		super();
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.nome = nome;
	}

	public ProdutosPedido() {
		super();
	}

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
