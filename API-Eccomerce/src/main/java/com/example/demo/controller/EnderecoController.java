package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ClienteInexistenteException;
import com.example.demo.exception.EnderecoExistenteException;
import com.example.demo.exception.EnderecoInexistenteException;
import com.example.demo.model.Endereco;
import com.example.demo.model.EnderecoDTO;
import com.example.demo.service.EnderecoService;


@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	
	@Autowired
    EnderecoService service;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        return new ResponseEntity<List<Endereco>>(service.listarTudo(), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Integer id) throws EnderecoInexistenteException {
        return new ResponseEntity<Endereco>(service.listarPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Endereco> insert( @RequestBody @Valid EnderecoDTO endereco) throws EnderecoExistenteException, ClienteInexistenteException {
        return new ResponseEntity<Endereco>(service.create(endereco), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> update(@RequestBody Endereco endereco, @PathVariable Integer id) {
        return new ResponseEntity<Endereco>(service.update(endereco, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) throws EnderecoInexistenteException {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
