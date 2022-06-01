package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UsuarioInexistenteException;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
    UsuarioService service;

    @GetMapping
    public List<Usuario> findAll(){
        return service.listarTudo();
    }

    @GetMapping(value = "/{id}")
    public Usuario findById(@PathVariable Integer id) throws UsuarioInexistenteException {
        return service.listarPorId(id);
    }

    @PostMapping
    public Usuario insert(@RequestBody Usuario usuario) {
        return service.create(usuario);
    }

    @PutMapping("/{id}")
    public Usuario update(@RequestBody Usuario usuario,@PathVariable Integer id) {
        return service.update(usuario, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws UsuarioInexistenteException {
        service.delete(id);
    }
}
