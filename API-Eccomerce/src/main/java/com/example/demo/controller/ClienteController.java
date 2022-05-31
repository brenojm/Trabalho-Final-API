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

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService service;
	
	@GetMapping
	public List<Cliente> findAll(){
		return service.listarTudo();
	}
	
	@GetMapping(value = "/{id}")
	public Cliente findById(@PathVariable Long id) {
		return service.listarPorId(id);
	}
	
	@PostMapping
	public Cliente insert(@RequestBody Cliente cliente) {
		return service.create(cliente);		
	}
	
	@PutMapping("/{id}")
	public Cliente update(@RequestBody Cliente cliente,@PathVariable Long id) {
		return service.update(cliente, id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	

}


