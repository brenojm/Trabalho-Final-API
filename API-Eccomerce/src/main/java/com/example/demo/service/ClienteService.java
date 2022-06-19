package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.MailConfig;
import com.example.demo.exception.ClienteExistenteException;
import com.example.demo.exception.ClienteInexistenteException;
import com.example.demo.model.Cliente;
import com.example.demo.model.ClienteDTO;
import com.example.demo.model.Usuario;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repositorio;
	
	@Autowired
	UsuarioService serviceUsuario;
	
	@Autowired
	MailConfig mailConfig;
	
	@Autowired
	BCryptPasswordEncoder bCrypt;
	
	
	public List<Cliente> listarTudo(){
		return repositorio.findAll();
	}
	
	public ClienteDTO listarPorId(Integer id) throws ClienteInexistenteException{
		Optional<Cliente> optional = repositorio.findById(id);		
		if (optional.isEmpty()) {
			throw new ClienteInexistenteException("Cliente inexistente");
		}
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setNome(optional.get().getNome());
		clienteDTO.setCpf(optional.get().getCpf());
		return clienteDTO;
	}
	
	public Cliente listarPorCpf(String cpf) {
		Optional<Cliente> optional = repositorio.findByCpf(cpf);
		return optional.get();
	}
	
	public Cliente getCliente(Integer id) throws ClienteInexistenteException {
		Optional<Cliente> optional = repositorio.findById(id);		
		if (optional.isEmpty()) {
			throw new ClienteInexistenteException("Cliente inexistente");
		}
		return optional.get();
	}
	
	public Cliente create(Cliente cliente) throws ClienteExistenteException {
		
		Usuario usuario = cliente.getUsuario();
		
		usuario.setRole("c");

		verificarClienteExiste(cliente);
		
		usuario.setSenha(bCrypt.encode(usuario.getSenha()));
		serviceUsuario.saveUsuario(usuario);
//		mailConfig.sendEmail(null, usuario.getEmail(), "Ativar Conta", "Ative sua conta no link abaixo:");
		repositorio.save(cliente);
		usuario.setCliente(cliente);
		serviceUsuario.saveUsuario(usuario);
		return cliente;
	}
	
	public void verificarClienteExiste(Cliente cliente) throws ClienteExistenteException {
		Optional<Cliente> optional = repositorio.findByCpf(cliente.getCpf());
		if (optional.isPresent()) {
			throw new ClienteExistenteException("Esse cliente já existe");
		}	
	}
	
    public Cliente update(Cliente cliente, Integer id) throws ClienteInexistenteException {
    	Optional<Cliente> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ClienteInexistenteException("Cliente não existe");
		}
		Cliente oldCliente = optional.get();
		if (cliente.getNome() != null) {
			if(!cliente.getNome().equals(""))
				
				oldCliente.setNome(cliente.getNome());
		}
		
		if (cliente.getTelefone() != null) {
			if(!cliente.getTelefone().equals("")) {
				oldCliente.setTelefone(cliente.getTelefone());
			}
		}

		return repositorio.save(oldCliente);
    }
    public void delete(Integer id) throws ClienteInexistenteException {
    	Optional<Cliente> optional = repositorio.findById(id);
    	if (optional.isEmpty()) {
			throw new ClienteInexistenteException("Cliente não existe");
		}
		repositorio.deleteById(id);
    	
    	
    }
}


