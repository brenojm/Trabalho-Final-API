package com.example.demo.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class PedidoDTO {
	
	private Integer id;
	
	private Integer numPedido;
	
	private Double valorTotalPed;
	
	@Temporal(TemporalType.DATE)
	private Date dataPedido;
	
	@Temporal(TemporalType.DATE)
	private Date dataEntrega;
	
	private String status;
	
	private Integer clienteId;

	public PedidoDTO() {
		super();
	}

	public PedidoDTO(Integer id, Integer numPedido, Double valorTotalPed, Date dataPedido, Date dataEntrega,
			String status, Integer clienteId) {
		super();
		this.id = id;
		this.numPedido = numPedido;
		this.valorTotalPed = valorTotalPed;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.status = status;
		this.clienteId = clienteId;
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

	public Double getValorTotalPed() {
		return valorTotalPed;
	}

	public void setValorTotalPed(Double valorTotalPed) {
		this.valorTotalPed = valorTotalPed;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
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
}
