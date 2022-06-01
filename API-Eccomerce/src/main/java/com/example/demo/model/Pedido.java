package com.example.demo.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer numPedido;
	
	
	private Double valorTotalPed;
	
	private Date dataPedido;
	
	private Date dataEntrega;
	
	private String status;
	
	@ManyToOne()
	@JoinColumn(name = "cliente_id",
				referencedColumnName = "id")
	private Cliente cliente;
	
	@ManyToMany
    @JoinTable( name = "pedido_produto",
                joinColumns = @JoinColumn(referencedColumnName = "id", name = "pedidoId"),
                inverseJoinColumns = @JoinColumn(referencedColumnName = "id", name = "produtoId"))
    public List<Produto> produtos;

	public Pedido() {
		super();

	}

	public Pedido(Integer id, Integer numPedido, Set<Produto> produtos, Double valorTotalPed, Date dataPedido, Date dataEntrega, String status) {
		super();
		this.id = id;
		this.numPedido = numPedido;
		this.valorTotalPed = valorTotalPed;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.status = status;
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
}
