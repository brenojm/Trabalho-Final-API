package com.example.demo.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ClienteExistenteException;
import com.example.demo.exception.ClienteInexistenteException;
import com.example.demo.model.Cliente;
import com.example.demo.model.ClienteDTO;
import com.example.demo.security.JWTUtil;
import com.example.demo.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService service;

	@Autowired
	JWTUtil jwtUtil;

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {

			List<Cliente> clientes = service.listarTudo();
			List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();

			for (Cliente cliente : clientes) {
				ClienteDTO clienteDTO = new ClienteDTO();
				clienteDTO.setId(cliente.getId());
				clienteDTO.setCpf(cliente.getCpf());
				clienteDTO.setNome(cliente.getNome());
				clientesDTO.add(clienteDTO);
			}
			return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.ACCEPTED);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) throws ClienteInexistenteException {
			return new ResponseEntity<Cliente>(service.listarPorId(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente) throws ClienteExistenteException {
		return new ResponseEntity<Cliente>(service.create(cliente), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@RequestHeader(required = true, name = "Authorization") String token,
			@RequestBody Cliente cliente, @PathVariable Integer id) throws ClienteInexistenteException {
		if (jwtUtil.getCredUser(token) == id) {
			return new ResponseEntity<Cliente>(service.update(cliente, id), HttpStatus.OK);
		}
		return new ResponseEntity<Cliente>(HttpStatus.UNAUTHORIZED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@RequestHeader(required = true, name = "Authorization") String token,
			@PathVariable Integer id) throws ClienteInexistenteException {
		Cliente cliente = service.getCliente(id);
		if (jwtUtil.getCredUser(token) == cliente.getUsuario().getIdUsuario()) {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

}
