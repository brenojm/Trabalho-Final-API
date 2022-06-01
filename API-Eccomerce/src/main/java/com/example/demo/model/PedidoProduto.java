package com.example.demo.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "PedidoProdutoEntity")
@Table(name = "pedido_produto")
public class PedidoProduto implements Serializable {

	@EmbeddedId
	private PedidoProdutoId pedidoProdutoId;

	
	private Integer quantidade;
	
	private Double preco;
	
	

	private PedidoProduto() {
	}

	private PedidoProduto(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
		pedidoProdutoId = new PedidoProduto.PedidoProdutoId();
		pedidoProdutoId.pedidoId = pedido.getId();
		pedidoProdutoId.produtoId = produto.getId();
		this.quantidade = quantidade;
		this.preco = preco;
		
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


	@Embeddable
	public static class PedidoProdutoId implements Serializable {

		private Integer pedidoId;
		private Integer produtoId;

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			PedidoProdutoId pedidoProdutoId = (PedidoProdutoId) o;
			return Objects.equals(pedidoId, pedidoProdutoId.pedidoId)
					&& Objects.equals(produtoId, pedidoProdutoId.produtoId);
		}

		@Override
		public int hashCode() {
			return Objects.hash(pedidoId, produtoId);
		}
	}
}
