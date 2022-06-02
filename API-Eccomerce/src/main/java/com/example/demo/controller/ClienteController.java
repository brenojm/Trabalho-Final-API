package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.exception.ClienteInexistenteException;
import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService service;

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		return new ResponseEntity<List<Cliente>>(service.listarTudo(), HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) throws ClienteInexistenteException {
		return new ResponseEntity<Cliente>(service.listarPorId(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente) {
		return new ResponseEntity<Cliente>(service.create(cliente), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable Integer id) {
		return new ResponseEntity<Cliente>(service.update(cliente, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) throws ClienteInexistenteException {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
