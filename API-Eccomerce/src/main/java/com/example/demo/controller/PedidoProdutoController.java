package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.PedidoProdutoInexistenteException;
import com.example.demo.model.PedidoProduto;
import com.example.demo.service.PedidoProdutoService;

@RestController
@RequestMapping("/pedido_produto")
public class PedidoProdutoController {

	@Autowired
	PedidoProdutoService service;

	@GetMapping
	public ResponseEntity<List<PedidoProduto>> findAll() {
		return new ResponseEntity<List<PedidoProduto>>(service.listarTudo(), HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PedidoProduto> findById(@PathVariable Integer id) throws PedidoProdutoInexistenteException {
		return new ResponseEntity<PedidoProduto>(service.listarPorId(id), HttpStatus.OK);
	}

//	@PostMapping
//	public ResponseEntity<PedidoProduto> insert(@RequestBody PedidoProduto pedidoProduto) {
//		return new ResponseEntity<PedidoProduto>(service.create(pedidoProduto, Integer id), HttpStatus.CREATED);
//	}

	@PutMapping("/{id}")
	public ResponseEntity<PedidoProduto> update(@RequestBody PedidoProduto pedidoProduto, @PathVariable Integer id) {
		return new ResponseEntity<PedidoProduto>(service.update(pedidoProduto, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) throws PedidoProdutoInexistenteException {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
