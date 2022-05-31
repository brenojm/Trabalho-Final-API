package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repositorio;
	
	public List<Cliente> listarTudo(){
		return repositorio.findAll();
	}
	
	public Cliente listarPorId(Long id) {
		Optional<Cliente> cliente = repositorio.findById(id);
		return cliente.get();
	}
	
	public Cliente create(Cliente cliente) {
		return repositorio.save(cliente);
	}
	
    public Cliente update(Cliente cliente,Long id) {
    	cliente.setId(id);
    	return repositorio.save(cliente);
    }
    public void delete(Long id) {
    	repositorio.deleteById(id);
    	
    }
}


