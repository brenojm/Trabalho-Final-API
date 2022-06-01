package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Funcionario> findAll(){
		return service.listarTudo();
	}
	
	@GetMapping(value = "/{id}")
	public Funcionario findById(@PathVariable Integer id) throws FuncionarioInexistenteException {
		return service.listarPorId(id);
	}
	
	@PostMapping
	public Funcionario insert(@RequestBody Funcionario funcionario) throws FuncionarioInexistenteException {
		return service.create(funcionario);		
	}
	
	@PutMapping("/{id}")
	public Funcionario update(@RequestBody Funcionario funcionario,@PathVariable Integer id) throws FuncionarioInexistenteException, FuncionarioExistenteException {
		return service.update(funcionario, id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws FuncionarioInexistenteException {
		service.delete(id);
	}
	
	

}
