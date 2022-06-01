package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PedidoProdutoExistenteException;
import com.example.demo.exception.PedidoProdutoInexistenteException;
import com.example.demo.model.PedidoProduto;
import com.example.demo.repository.PedidoProdutoRepository;

@Service
public class PedidoProdutoService {

	@Autowired
	PedidoProdutoRepository repositorio;

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

	public PedidoProduto create(PedidoProduto pedidoProduto) {
		return repositorio.save(pedidoProduto);
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
}
