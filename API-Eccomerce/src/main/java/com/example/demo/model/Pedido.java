package com.example.demo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer numPedido;
	
	private  Set<Produto> produtos;
	
	private Double valorTotalPed;
	
	private Date dataPedido;

	public Pedido() {
		super();

	}

	public Pedido(Integer id, Integer numPedido, Set<Produto> produtos, Double valorTotalPed, Date dataPedido) {
		super();
		this.id = id;
		this.numPedido = numPedido;
		this.produtos = produtos;
		this.valorTotalPed = valorTotalPed;
		this.dataPedido = dataPedido;
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

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
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
}