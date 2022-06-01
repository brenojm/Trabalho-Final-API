package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PedidoProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne()
	@JoinColumn(name = "produto_id",
				referencedColumnName = "id")
	private Produto produto;
	
	@ManyToOne()
	@JoinColumn(name = "pedido_id",
				referencedColumnName = "id")
	private Pedido pedido;
	
	private Integer quantidade;
	
	private Double preco;

	public PedidoProduto() {
		super();
	}

	public PedidoProduto(Integer id, Produto produto, Pedido pedido, Integer quantidade, Double preco) {
		super();
		this.id = id;
		this.produto = produto;
		this.pedido = pedido;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
}
