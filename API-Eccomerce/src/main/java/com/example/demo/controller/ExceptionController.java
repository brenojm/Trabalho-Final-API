package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.CategoriaExistenteException;
import com.example.demo.exception.CategoriaInexistenteException;
import com.example.demo.exception.ClienteExistenteException;
import com.example.demo.exception.ClienteInexistenteException;
import com.example.demo.exception.EmailNotException;
import com.example.demo.exception.EnderecoExistenteException;
import com.example.demo.exception.EnderecoInexistenteException;
import com.example.demo.exception.FuncionarioExistenteException;
import com.example.demo.exception.FuncionarioInexistenteException;
import com.example.demo.exception.PedidoExistenteException;
import com.example.demo.exception.PedidoInexistenteException;
import com.example.demo.exception.PedidoProdutoExistenteException;
import com.example.demo.exception.PedidoProdutoInexistenteException;
import com.example.demo.exception.ProdutoExistenteException;
import com.example.demo.exception.ProdutoInexistenteException;
import com.example.demo.exception.UsuarioExistenteException;
import com.example.demo.exception.UsuarioInexistenteException;

@RestControllerAdvice
public class ExceptionController {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errosOcorridos = new HashMap<>();

		List<ObjectError> erros = ex.getBindingResult().getAllErrors();
		for (ObjectError erro : erros) {

			String atributo = ((FieldError) erro).getField();

			String mensagem = erro.getDefaultMessage();
			errosOcorridos.put(atributo, mensagem);
		}
		return errosOcorridos;
	}

	@ExceptionHandler(CategoriaExistenteException.class)
	public ResponseEntity<?> categoriaExistenteException(CategoriaExistenteException exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("erro", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CategoriaInexistenteException.class)
	public ResponseEntity<?> categoriaInexistenteException(CategoriaInexistenteException exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("erro", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ClienteExistenteException.class)
	public ResponseEntity<?> clienteExistenteException(ClienteExistenteException exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("erro", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ClienteInexistenteException.class)
	public ResponseEntity<?> clienteInexistenteException(ClienteInexistenteException exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("erro", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(FuncionarioExistenteException.class)
	public ResponseEntity<?> funcionarioExistenteException(FuncionarioExistenteException exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("erro", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(FuncionarioInexistenteException.class)
	public ResponseEntity<?> funcionarioInexistenteException(FuncionarioInexistenteException exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("erro", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PedidoExistenteException.class)
	public ResponseEntity<?> pedidoExistenteException(PedidoExistenteException exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("erro", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PedidoInexistenteException.class)
	public ResponseEntity<?> pedidoInexistenteExceptiona(PedidoInexistenteException exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("erro", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PedidoProdutoExistenteException.class)
	public ResponseEntity<?> pedidoProdutoExistenteException(PedidoProdutoExistenteException exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("erro", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PedidoProdutoInexistenteException.class)
	public ResponseEntity<?> pedidoProdutoInexistenteException(PedidoProdutoInexistenteException exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("erro", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ProdutoExistenteException.class)
	public ResponseEntity<?> produtoExistenteException(ProdutoExistenteException exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("erro", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ProdutoInexistenteException.class)
	public ResponseEntity<?> produtoInexistenteException(ProdutoInexistenteException exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("erro", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UsuarioExistenteException.class)
	public ResponseEntity<?> usuarioExistenteException(UsuarioExistenteException exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("erro", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UsuarioInexistenteException.class)
	public ResponseEntity<?> usuarioInexistenteException(UsuarioInexistenteException exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("erro", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EnderecoExistenteException.class)
	public ResponseEntity<?> enderecoExistenteException(EnderecoExistenteException exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("erro", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EnderecoInexistenteException.class)
	public ResponseEntity<?> enderecoInexistenteException(EnderecoInexistenteException exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("erro", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmailNotException.class)
	public ResponseEntity<?> emailNotException(EmailNotException exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("erro", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}

}
