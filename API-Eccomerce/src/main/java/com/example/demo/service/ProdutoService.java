package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ProdutoExistenteException;
import com.example.demo.exception.ProdutoInexistenteException;
import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repositorio;

	public List<Produto> listarTudo() {
		return repositorio.findAll();
	}

	public Produto listarConta(Integer id) throws ProdutoInexistenteException {
		Optional<Produto> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ProdutoInexistenteException("Produto não cadastrado");
		}
		return optional.get();
	}

	public void verificarExiste(Produto produto) throws ProdutoExistenteException {
		Optional<Produto> optional = repositorio.findByNome(produto.getNome());
		if (optional.isPresent()) {
			throw new ProdutoExistenteException("Produto já cadastrado");
		}
	}

	public void inserir(Produto produto) throws ProdutoExistenteException {
		verificarExiste(produto);
		repositorio.save(produto);
	}

	public Produto atualizar(Produto produto, Integer id)
			throws ProdutoInexistenteException, ProdutoExistenteException {
		Optional<Produto> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ProdutoInexistenteException("Produto não cadastrado");
		}
		Produto oldProduto = optional.get();
		if (produto.getNome() != null) {
			if (!produto.getNome().equals("")) {
				verificarExiste(produto);
				oldProduto.setNome(produto.getNome());
			}
		}
		if (produto.getDescricao() != null) {
			if (!produto.getDescricao().equals("")) {
				oldProduto.setDescricao(produto.getDescricao());
			}
		}

		if (produto.getPreco() != null) {
			oldProduto.setPreco(produto.getPreco());
		}
		if (produto.getQuantidadeEstoque() != null) {
			oldProduto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
		}
		if (produto.getDataCadastro() != null) {
			oldProduto.setDataCadastro(produto.getDataCadastro());
		}

		return repositorio.save(oldProduto);

	}

	public void deletar(Integer id) throws ProdutoInexistenteException {
		Optional<Produto> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ProdutoInexistenteException("Produto não cadastrado");
		}
		repositorio.deleteById(id);
	}

}
