package com.example.demo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class PedidoDTO {
	
	private Integer id;
	
	private Integer numPedido;
	
	@Temporal(TemporalType.DATE)
	private Date dataPedido;
	
	private String status;
	
	private Integer clienteId;
	
	private Set<ProdutosPedido> produtos;

	public PedidoDTO() {
		super();
	}
	
	public PedidoDTO(Integer id, Integer numPedido, Date dataPedido, String status, Integer clienteId,
			Set<ProdutosPedido> produtos) {
		super();
		this.id = id;
		this.numPedido = numPedido;
		this.dataPedido = dataPedido;
		this.status = status;
		this.clienteId = clienteId;
		this.produtos = produtos;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(Integer numPedido) {
		this.numPedido = numPedido;
	}

	public Date getDataPedido() {
		Date date = new Date(System.currentTimeMillis());
		return date;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public Set<ProdutosPedido> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<ProdutosPedido> produtos) {
		this.produtos = produtos;
	}
	
	
	
}
