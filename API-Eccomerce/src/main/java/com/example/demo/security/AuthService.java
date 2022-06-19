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
		System.out.println(username);
		Usuario usuario = service.getUsuarioPorEmail(username);
		if (usuario.getRole().equals("c")) {
			return new UserSS(String.format("%s-%s-%s", usuario.getCliente().getId(),
					usuario.getEmail(), usuario.getRole()), usuario.getSenha());
		}
		if (usuario.getRole().equals("f"))
			return new UserSS(String.format("%s-%s-%s", usuario.getFuncionario().getIdFuncionario(),
					usuario.getEmail(), usuario.getRole()), usuario.getSenha());
		return new UserSS(usuario.getEmail(), usuario.getSenha());
	}

}
