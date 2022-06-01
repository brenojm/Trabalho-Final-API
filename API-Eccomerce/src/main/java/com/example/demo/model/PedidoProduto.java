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
	public PedidoProdutoId pedidoProdutoId;

	// Our extra column
	public Instant createdDate;

	public PedidoProduto() {
	}

	public PedidoProduto(Pedido pedido, Produto produto) {
		pedidoProdutoId = new PedidoProduto.PedidoProdutoId();
		pedidoProdutoId.pedidoId = pedido.getId();
		pedidoProdutoId.produtoId = produto.getId();
		createdDate = Instant.now();
	}

	@Embeddable
	public static class PedidoProdutoId implements Serializable {

		public Integer pedidoId;
		public Integer produtoId;

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
