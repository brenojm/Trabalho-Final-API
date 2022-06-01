package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserExistenteException;
import com.example.demo.exception.UserInexistenteException;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UserRepository;

@Service
public  class UserService {
	
	@Autowired
	UserRepository repositorio;
	
	public List<Usuario> listarTudo(){
		return repositorio.findAll();
	}
	
	public Usuario listarPorId(Integer idUsuario) throws UserInexistenteException{
		Optional<Usuario> optional = repositorio.findById(idUsuario);		
		if (optional.isEmpty()) {
			throw new UserInexistenteException("User inexistente");
		}
		return optional.get();
	}
	
	public Usuario create(Usuario usuario) {
		return repositorio.save(usuario);
	}
	
	public void verificarClienteExiste(Usuario usuario) throws UserExistenteException {
		Optional<Usuario> optional = repositorio.findById(usuario.getIdUsuario());
		if (optional.isPresent()) {
			throw new UserExistenteException("Esse user ja existe");
		}	
	}
	
    public Usuario update(Usuario usuario, Integer idUsuario) {
    	usuario.setIdUsuario(idUsuario);
    	return repositorio.save(usuario);
    }
    public void delete(Integer idUsuario) throws UserInexistenteException {
    	Optional<Usuario> optional = repositorio.findById(idUsuario);
    	if (optional.isEmpty()) {
			throw new UserInexistenteException("User não existe");
		}
		repositorio.deleteById(idUsuario);
    }
}
