package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UsuarioExistenteException;
import com.example.demo.exception.UsuarioInexistenteException;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public  class UsuarioService {
	
	@Autowired
	UsuarioRepository repositorio;
	
	@Autowired
	BCryptPasswordEncoder bCrypt;
	
	
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
		}
		return optional.get();
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
    
    public void saveUsuario(Usuario usuario) {
    	repositorio.save(usuario);
    }
}
