package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	Optional<Pedido> findByNumPedido(Integer numPedido);
}
