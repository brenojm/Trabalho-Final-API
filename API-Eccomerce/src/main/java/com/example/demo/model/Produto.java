package com.example.demo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	private Integer quantidadeEstoque;
	
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	// imagem
	
	@OneToMany(mappedBy = "produto")
	private Set<PedidoProduto> pedidoProdutos;
	
	
	@ManyToOne
	@JoinColumn(name = "categoria_id",
				referencedColumnName = "id")	
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id",
				referencedColumnName = "funcionario_id")	
	private Funcionario funcionario;
	
	public Produto() {
		super();
	}
	
	public Produto(Integer id, String nome, String descricao, Double preco, Integer quantidadeEstoque,
			Date dataCadastro, Set<PedidoProduto> pedidoProdutos, Categoria categoria, Funcionario funcionario) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
		this.dataCadastro = dataCadastro;
		this.pedidoProdutos = pedidoProdutos;
		this.categoria = categoria;
		this.funcionario = funcionario;
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
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public Set<PedidoProduto> getPedidoProdutos() {
		return pedidoProdutos;
	}
	public void setPedidoProdutos(Set<PedidoProduto> pedidoProdutos) {
		this.pedidoProdutos = pedidoProdutos;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
