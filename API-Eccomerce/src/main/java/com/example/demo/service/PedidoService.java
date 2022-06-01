package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PedidoExistenteException;
import com.example.demo.exception.PedidoInexistenteException;
import com.example.demo.model.Pedido;
import com.example.demo.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository repositorio;

	public List<Pedido> listarTudo() {
		return repositorio.findAll();
	}

	public Pedido listarPedido(Integer id) throws PedidoInexistenteException {
		Optional<Pedido> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new PedidoInexistenteException("Pedido não cadastrado");
		}
		return optional.get();
	}

	public void verificarExiste(Pedido pedido) throws PedidoExistenteException {
		Optional<Pedido> optional = repositorio.findByNumPedido(pedido.getNumPedido());
		if (optional.isPresent()) {
			throw new PedidoExistenteException("Pedido já cadastrado");
		}
	}

	public void inserir(Pedido pedido) throws PedidoExistenteException {
		verificarExiste(pedido);
		repositorio.save(pedido);
	}

	public Pedido atualizar(Pedido pedido, Integer id)
			throws PedidoInexistenteException, PedidoExistenteException {
		Optional<Pedido> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new PedidoInexistenteException("Pedido não cadastrado");
		}
		Pedido oldPedido = optional.get();
		if (pedido.getNumPedido() != null) {
				verificarExiste(pedido);
				oldPedido.setNumPedido(pedido.getNumPedido());
		}
		
		if (pedido.getValorTotalPed() != null) {
			oldPedido.setValorTotalPed(pedido.getValorTotalPed());
		}
		
		if (pedido.getDataPedido() != null) {
			oldPedido.setDataPedido(pedido.getDataPedido());
		}
		
		if(pedido.getDataEntrega() != null) {
			oldPedido.setDataEntrega(pedido.getDataEntrega());
		}
		
		if(pedido.getStatus() != null) {
			oldPedido.setStatus(pedido.getStatus());
		}
		return repositorio.save(oldPedido);

	}

	public void deletar(Integer id) throws PedidoInexistenteException {
		Optional<Pedido> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new PedidoInexistenteException("Pedido não cadastrado");
		}
		repositorio.deleteById(id);
	}
}
