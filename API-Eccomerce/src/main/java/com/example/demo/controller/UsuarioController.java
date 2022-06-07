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

import com.example.demo.exception.UsuarioInexistenteException;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		return new ResponseEntity<List<Usuario>>(service.listarTudo(), HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) throws UsuarioInexistenteException {
		return new ResponseEntity<Usuario>(service.listarPorId(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario, @PathVariable Integer id) {
		return new ResponseEntity<Usuario>(service.update(usuario, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) throws UsuarioInexistenteException {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
