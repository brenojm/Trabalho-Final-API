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

import com.example.demo.exception.PedidoProdutoInexistenteException;
import com.example.demo.model.PedidoProduto;
import com.example.demo.service.PedidoProdutoService;

@RestController
@RequestMapping("/pedido_produto")
public class PedidoProdutoController {
	
	@Autowired
    PedidoProdutoService service;

    @GetMapping
    public List<PedidoProduto> findAll(){
        return service.listarTudo();
    }

    @GetMapping(value = "/{id}")
    public PedidoProduto findById(@PathVariable Integer id) throws PedidoProdutoInexistenteException {
        return service.listarPorId(id);
    }

    @PostMapping
    public PedidoProduto insert(@RequestBody PedidoProduto pedidoProduto) {
        return service.create(pedidoProduto);
    }

    @PutMapping("/{id}")
    public PedidoProduto update(@RequestBody PedidoProduto pedidoProduto,@PathVariable Integer id) {
        return service.update(pedidoProduto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws PedidoProdutoInexistenteException {
        service.delete(id);
    }
}
