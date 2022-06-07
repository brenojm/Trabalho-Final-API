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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ClienteInexistenteException;
import com.example.demo.exception.PedidoExistenteException;
import com.example.demo.exception.PedidoInexistenteException;
import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoDTO;
import com.example.demo.security.JWTUtil;
import com.example.demo.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	PedidoService service;

	@Autowired
	JWTUtil jwtUtil;

	@GetMapping
	public ResponseEntity<List<Pedido>> getAll(@RequestHeader(required = true, name = "Authorization") String token) {
		if (jwtUtil.getCredentials(token).equals("f")) {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Lista de Pedidos", "Segue todos os pedidos cadastrados");
			return new ResponseEntity<List<Pedido>>(service.listarTudo(), headers, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

	}

	@GetMapping("/{numero}")
	public ResponseEntity<Pedido> getOne(@RequestHeader(required = true, name = "Authorization") String token,
			@PathVariable Integer numero) throws PedidoInexistenteException {
		if (jwtUtil.getCredentials(token).equals("c") && jwtUtil.getCredUser(token) == service.getUserId(numero)) {
			return new ResponseEntity<Pedido>(service.listarPedido(numero), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestHeader(required = true, name = "Authorization") String token,
			@RequestBody PedidoDTO pedidoDTO)
			throws PedidoExistenteException, ClienteInexistenteException, PedidoInexistenteException {
		if (jwtUtil.getCredentials(token).equals("c")) {
			service.inserir(pedidoDTO);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	@PutMapping("/{numero}")
	public ResponseEntity<Pedido> update(@RequestHeader(required = true, name = "Authorization") String token,
			@RequestBody String status, @PathVariable Integer numero)
			throws PedidoInexistenteException, PedidoExistenteException {
		if (jwtUtil.getCredentials(token).equals("c")) {
			return new ResponseEntity<Pedido>(service.atualizar(status, numero), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	@DeleteMapping("/{numero}")
	public ResponseEntity<?> delete(@RequestHeader(required = true, name = "Authorization") String token,
			@PathVariable Integer numero) throws PedidoInexistenteException {
		if (jwtUtil.getCredentials(token).equals("f") || jwtUtil.getCredUser(token) == service.getUserId(numero)) {
			service.deletar(numero);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

}
