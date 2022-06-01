package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PedidoProduto;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, PedidoProduto.PedidoProdutoId> {

}
