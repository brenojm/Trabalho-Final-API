package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ClienteExistenteException;
import com.example.demo.exception.ClienteInexistenteException;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repositorio;
	
	public List<Cliente> listarTudo(){
		return repositorio.findAll();
	}
	
	public Cliente listarPorId(Integer id) throws ClienteInexistenteException{
		Optional< Cliente> optional = repositorio.findById(id);		
		if (optional.isEmpty()) {
			throw new ClienteInexistenteException("Cliente inexistente");
		}
		return optional.get();
	}
	
	public  Cliente create( Cliente cliente) {
		return repositorio.save(cliente);
	}
	
	public void verificarClienteExiste(Cliente cliente) throws ClienteExistenteException {
		Optional<Cliente> optional = repositorio.findById(cliente.getId());
		if (optional.isPresent()) {
			throw new ClienteExistenteException("Esse cliente ja existe");
		}	
	}
	
    public Cliente update(Cliente cliente, Integer id) {
    	cliente.setId(id);
    	return repositorio.save(cliente);
    }
    public void delete(Integer id) throws ClienteInexistenteException {
    	Optional<Cliente> optional = repositorio.findById(id);
    	if (optional.isEmpty()) {
			throw new ClienteInexistenteException("Cliente não existe");
		}
		repositorio.deleteById(id);
    	
    	
    }
}


