package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PedidoInexistenteException;
import com.example.demo.exception.PedidoProdutoExistenteException;
import com.example.demo.exception.PedidoProdutoInexistenteException;
import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoProduto;
import com.example.demo.model.Produto;
import com.example.demo.model.ProdutosPedido;
import com.example.demo.repository.PedidoProdutoRepository;

@Service
public class PedidoProdutoService {

	@Autowired
	PedidoProdutoRepository repositorio;
	
	@Autowired
	ProdutoService servicePro;
	
	private Double valorTotal= 0.0;

	public List<PedidoProduto> listarTudo() {
		return repositorio.findAll();
	}

	public PedidoProduto listarPorId(Integer id) throws PedidoProdutoInexistenteException {
		Optional<PedidoProduto> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new PedidoProdutoInexistenteException("pedidoProduto inexistente");
		}
		return optional.get();
	}

	public Double create(Set<ProdutosPedido> produtos, Pedido pedido) throws PedidoInexistenteException {
		Double valorTotal= 0.0;
		
		
		for (ProdutosPedido produto : produtos) {
			Produto produtoNovo = servicePro.getPorId(produto.getIdProduto());
			PedidoProduto pedidoProduto = new PedidoProduto();
			Double valor = 0.0;
			pedidoProduto.setPreco(valor += produtoNovo.getPreco()*produto.getQuantidade());
			valorTotal += valor;
			pedidoProduto.setQuantidade(produto.getQuantidade());
			pedidoProduto.setPedido(pedido);
			pedidoProduto.setProduto(produtoNovo);
			repositorio.save(pedidoProduto);
			repositorio.save(pedidoProduto);
			produtoNovo.setQuantidadeEstoque(produtoNovo.getQuantidadeEstoque()-produto.getQuantidade());
		}
		
		return valorTotal;
		
		
	}

	public void verificarPedidoProdutoExiste(PedidoProduto pedidoProduto) throws PedidoProdutoExistenteException {
		Optional<PedidoProduto> optional = repositorio.findById(pedidoProduto.getId());
		if (optional.isPresent()) {
			throw new PedidoProdutoExistenteException("Esse pedidoProduto ja existe");
		}
	}

	public PedidoProduto update(PedidoProduto pedidoProduto, Integer id) {
		pedidoProduto.setId(id);
		return repositorio.save(pedidoProduto);
	}

	public void delete(Integer id) throws PedidoProdutoInexistenteException {
		Optional<PedidoProduto> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new PedidoProdutoInexistenteException("pedidoProduto não existe");
		}
		repositorio.deleteById(id);
	}
	
	public Double getValorTotal() {
		return valorTotal;
	}
}
