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

import com.example.demo.exception.FuncionarioExistenteException;
import com.example.demo.exception.FuncionarioInexistenteException;
import com.example.demo.exception.UsuarioInexistenteException;
import com.example.demo.model.Funcionario;
import com.example.demo.model.FuncionarioDTO;
import com.example.demo.security.JWTUtil;
import com.example.demo.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	FuncionarioService service;
	
	@Autowired
	JWTUtil jwtUtil;
	
	
	@GetMapping
	public ResponseEntity<List<FuncionarioDTO>> findAll(@RequestHeader(required=true,name="Authorization")String token) {
		if(jwtUtil.getCredentials(token).equals("f")) {
			List<Funcionario> funcionarios = service.listarTudo();
			List<FuncionarioDTO> funcionariosDTO = new ArrayList<FuncionarioDTO>();

			for (Funcionario funcionario : funcionarios) {
				FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
				funcionarioDTO.setId(funcionario.getIdFuncionario());
				funcionarioDTO.setCpf(funcionario.getCpf());
				funcionarioDTO.setNome(funcionario.getNome());
				funcionariosDTO.add(funcionarioDTO);
			}

			return new ResponseEntity<List<FuncionarioDTO>>(funcionariosDTO, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
	}

	@GetMapping(value = "/{cpf}")
	public ResponseEntity<FuncionarioDTO> findById(@RequestHeader(required=true,name="Authorization")String token,@PathVariable String cpf) throws FuncionarioInexistenteException {
		if(jwtUtil.getCredentials(token).equals("f")) {
			Funcionario funcionario = service.listarPorCpf(cpf);
			FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
			funcionarioDTO.setId(funcionario.getIdFuncionario());
			funcionarioDTO.setCpf(funcionario.getCpf());
			funcionarioDTO.setNome(funcionario.getNome());

			return new ResponseEntity<FuncionarioDTO>(funcionarioDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}


	
	@PostMapping
	public ResponseEntity<Funcionario> cadastrar(@RequestHeader(required=true,name="Authorization")String token,@RequestBody Funcionario funcionario)
			throws FuncionarioExistenteException, UsuarioInexistenteException {
		if(jwtUtil.getCredentials(token).equals("f")) {
			
		return new ResponseEntity<Funcionario>(service.create(funcionario), HttpStatus.CREATED);
		}
		return new ResponseEntity<Funcionario>(HttpStatus.UNAUTHORIZED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> update(@RequestHeader(required=true,name="Authorization")String token,@RequestBody Funcionario funcionario, @PathVariable Integer id)
			throws FuncionarioInexistenteException, FuncionarioExistenteException {
		if(jwtUtil.getCredentials(token).equals("f")) {
			return new ResponseEntity<Funcionario>(service.update(funcionario, id), HttpStatus.OK);
		}
		return new ResponseEntity<Funcionario>(HttpStatus.UNAUTHORIZED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@RequestHeader(required=true,name="Authorization")String token,@PathVariable Integer id) throws FuncionarioInexistenteException {
		if(jwtUtil.getCredentials(token).equals("f")) {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<Funcionario>(HttpStatus.UNAUTHORIZED);
	}

}
