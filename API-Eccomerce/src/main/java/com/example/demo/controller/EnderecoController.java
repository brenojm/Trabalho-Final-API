package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ClienteInexistenteException;
import com.example.demo.exception.EnderecoExistenteException;
import com.example.demo.exception.EnderecoInexistenteException;
import com.example.demo.exception.UsuarioInexistenteException;
import com.example.demo.model.Endereco;
import com.example.demo.model.EnderecoDTO;
import com.example.demo.security.JWTUtil;
import com.example.demo.service.EnderecoService;


@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	
	@Autowired
    EnderecoService service;
	
	@Autowired
	JWTUtil jwtUtil;

//    @GetMapping
//    public ResponseEntity<List<Endereco>> findAll() {
//        return new ResponseEntity<List<Endereco>>(service.listarTudo(), HttpStatus.ACCEPTED);
//    }
//
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Endereco> findById(@PathVariable Integer id) throws EnderecoInexistenteException {
//        return new ResponseEntity<Endereco>(service.listarPorId(id), HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<Endereco> insert(@RequestHeader(required=true,name="Authorization")String token,@RequestBody @Valid EnderecoDTO endereco) throws EnderecoExistenteException, ClienteInexistenteException, UsuarioInexistenteException {
    	if(jwtUtil.getCredUser(token) == endereco.getIdUsuario()) {
    		return new ResponseEntity<Endereco>(service.create(endereco), HttpStatus.CREATED);
    	}
    	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> update(@RequestHeader(required=true,name="Authorization")String token,@RequestBody Endereco endereco, @PathVariable Integer id) {
    	if(jwtUtil.getCredUser(token) == endereco.getUsuario().getIdUsuario()) {
    		return new ResponseEntity<Endereco>(service.update(endereco, id), HttpStatus.OK);
    	}
    	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@RequestHeader(required=true,name="Authorization")String token,@PathVariable Integer id) throws EnderecoInexistenteException {
    	if(jwtUtil.getCredUser(token) == id) {
    		service.delete(id);
    		return new ResponseEntity<>(HttpStatus.OK);
    	}
    	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    	
    }
}
