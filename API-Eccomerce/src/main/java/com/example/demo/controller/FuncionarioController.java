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

import com.example.demo.exception.FuncionarioExistenteException;
import com.example.demo.exception.FuncionarioInexistenteException;
import com.example.demo.model.Funcionario;
import com.example.demo.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	FuncionarioService service;

	@GetMapping
	public ResponseEntity<List<Funcionario>> findAll() {
		return new ResponseEntity<List<Funcionario>>(service.listarTudo(), HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Funcionario> findById(@PathVariable Integer id) throws FuncionarioInexistenteException {
		return new ResponseEntity<Funcionario>(service.listarPorId(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Funcionario> insert(@RequestBody Funcionario funcionario)
			throws FuncionarioExistenteException {
		return new ResponseEntity<Funcionario>(service.create(funcionario), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> update(@RequestBody Funcionario funcionario, @PathVariable Integer id)
			throws FuncionarioInexistenteException, FuncionarioExistenteException {
		return new ResponseEntity<Funcionario>(service.update(funcionario, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) throws FuncionarioInexistenteException {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
