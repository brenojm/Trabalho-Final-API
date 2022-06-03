package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
	UsuarioService service;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = service.getUsuarioPorEmail(username);
		return new UserSS(usuario.getEmail(), usuario.getSenha());
	}

}
