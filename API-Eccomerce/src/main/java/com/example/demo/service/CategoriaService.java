package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.CategoriaExistenteException;
import com.example.demo.exception.CategoriaInexistenteException;
import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository repositorio;

	public List<Categoria> listarTudo() {
		return repositorio.findAll();
	}

	public Categoria listarConta(Integer id) throws CategoriaInexistenteException{
		Optional<Categoria> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new CategoriaInexistenteException("Categoria não existente");
		}
		return optional.get();
	}

	public void verificarExiste(Categoria categoria) throws CategoriaExistenteException{
		Optional<Categoria> optional = repositorio.findByNome(categoria.getNome());
		if (optional.isPresent()) {
			throw new CategoriaExistenteException("Categoria já cadastrado");
		}
	}

	public void inserir(Categoria categoria) throws CategoriaExistenteException{
		verificarExiste(categoria);
		repositorio.save(categoria);
	}

	public Categoria atualizar(Categoria categoria, Integer id) throws CategoriaInexistenteException, CategoriaExistenteException{
		Optional<Categoria> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new CategoriaInexistenteException("Categoria não existente");
		}
		Categoria oldCategoria = optional.get();
		if (categoria.getNome() != null) {
			if (!categoria.getNome().equals("")) {
				verificarExiste(categoria);
				oldCategoria.setNome(categoria.getNome());
			}
		}
		if (categoria.getDescricao() != null) {
			if (!categoria.getDescricao().equals("")) {
				oldCategoria.setDescricao(categoria.getDescricao());
			}
		}

		return repositorio.save(oldCategoria);

	}

	public void deletar(Integer id) throws CategoriaInexistenteException{
		Optional<Categoria> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new CategoriaInexistenteException("Categoria não existente");
		}
		repositorio.deleteById(id);
	}
}
