package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ClienteExistenteException;
import com.example.demo.exception.UsuarioExistenteException;
import com.example.demo.exception.UsuarioInexistenteException;
import com.example.demo.model.Cliente;
import com.example.demo.model.Usuario;
import com.example.demo.model.UsuarioDTO;
import com.example.demo.repository.UsuarioRepository;

@Service
public  class UsuarioService {
	
	@Autowired
	UsuarioRepository repositorio;
	
	@Autowired
	BCryptPasswordEncoder bCrypt;
	
	@Autowired
	ClienteService serviceCli;
	
	public List<Usuario> listarTudo(){
		return repositorio.findAll();
	}
	
	public Usuario listarPorId(Integer idUsuario) throws UsuarioInexistenteException{
		Optional<Usuario> optional = repositorio.findById(idUsuario);		
		if (optional.isEmpty()) {
			throw new UsuarioInexistenteException("User inexistente");
		}
		return optional.get();
	}
	
	public Usuario getUsuarioPorEmail(String email) {
		Optional<Usuario> optional = repositorio.findByEmail(email);
		if (optional.isEmpty()) {
			return null;
			//to-do tratar erro
		}
		return optional.get();
	}
	
	public UsuarioDTO create(UsuarioDTO usuarioDTO) throws ClienteExistenteException {
		Usuario usuario = new Usuario();
		Cliente cliente = new Cliente();
		
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setSenha(usuarioDTO.getSenha());
		usuario.setUsername(usuarioDTO.getUsername());
		serviceCli.create(usuarioDTO.getCliente());	
		usuario.setCliente(usuarioDTO.getCliente());
		usuario.setRole("C");
		
		usuario.setSenha(bCrypt.encode(usuario.getSenha()));
		cliente = usuario.getCliente();
		cliente.setUsuario(usuario);
		repositorio.save(usuario);
		return usuarioDTO;
	}
	
	public void verificarClienteExiste(Usuario usuario) throws UsuarioExistenteException {
		Optional<Usuario> optional = repositorio.findById(usuario.getIdUsuario());
		if (optional.isPresent()) {
			throw new UsuarioExistenteException("Esse user ja existe");
		}	
	}
	
    public Usuario update(Usuario usuario, Integer idUsuario) {
    	usuario.setIdUsuario(idUsuario);
    	return repositorio.save(usuario);
    }
    public void delete(Integer idUsuario) throws UsuarioInexistenteException {
    	Optional<Usuario> optional = repositorio.findById(idUsuario);
    	if (optional.isEmpty()) {
			throw new UsuarioInexistenteException("User não existe");
		}
		repositorio.deleteById(idUsuario);
    }
}
