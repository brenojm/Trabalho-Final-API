package com.example.demo.security;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.demo.service.UsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	@Autowired
	UsuarioService serviceUsuario;

	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();
	}

	public static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		System.out.println(token);
		if (token != null) {
			String user = Jwts.parser().setSigningKey("serratec".getBytes()).parseClaimsJws(token.replace("Bearer", ""))
					.getBody().getSubject();
			if (user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
			}
		}
		// to-do tratar erro
		return null;
	}

	public String getCredentials(String token) {
		if (token != null) {
			String user = Jwts.parser().setSigningKey("serratec".getBytes()).parseClaimsJws(token.replace("Bearer", ""))
					.getBody().getSubject();
			if (user != null) {
				return serviceUsuario.getUsuarioPorToken(user).getRole();
			}
		}
	return null;
	//to-do erro
	}
	
	//Identificar se é o usuario que esta mexendo na propria conta
	public Integer getCredUser(String token) {
		if (token != null) {
			String user = Jwts.parser().setSigningKey("serratec".getBytes()).parseClaimsJws(token.replace("Bearer", ""))
					.getBody().getSubject();
			if (user != null) {
				return serviceUsuario.getUsuarioPorToken(user).getIdUsuario();
			}
		}
	return null;
	//to-do erro
	}
}
