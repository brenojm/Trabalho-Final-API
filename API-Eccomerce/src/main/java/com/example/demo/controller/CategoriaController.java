package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CategoriaExistenteException;
import com.example.demo.exception.CategoriaInexistenteException;
import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService service;

	@GetMapping
	public ResponseEntity<List<Categoria>> getAll() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Lista de Produtos", "Segue todos os produtos cadastrados");
		return new ResponseEntity<List<Categoria>>(service.listarTudo(), headers, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{numero}")
	public ResponseEntity<Categoria> getOne(@PathVariable Integer numero) throws CategoriaInexistenteException {
		return new ResponseEntity<Categoria>(service.listarCategoria(numero), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody Categoria categoria) throws CategoriaExistenteException {
		service.inserir(categoria);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{numero}")
	public ResponseEntity<Categoria> update(@RequestBody Categoria categoria, @PathVariable Integer numero)
			throws CategoriaInexistenteException, CategoriaExistenteException {
		return new ResponseEntity<Categoria>(service.atualizar(categoria, numero), HttpStatus.OK);
	}

	@DeleteMapping("/{numero}")
	public ResponseEntity<?> delete(@PathVariable Integer numero) throws CategoriaInexistenteException {
		service.deletar(numero);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
