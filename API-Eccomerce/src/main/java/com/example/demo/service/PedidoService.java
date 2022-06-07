package com.example.demo.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ClienteInexistenteException;
import com.example.demo.exception.PedidoExistenteException;
import com.example.demo.exception.PedidoInexistenteException;
import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoDTO;
import com.example.demo.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository repositorio;
	
	@Autowired
	ClienteService serviceCli;
	
	@Autowired
	PedidoProdutoService servicePedidoProduto;
	
	@Autowired
	ProdutoService servicePro;

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

	public void inserir(PedidoDTO pedidoDTO) throws PedidoExistenteException, ClienteInexistenteException, PedidoInexistenteException {		
		Pedido pedido = new Pedido();
		
		pedido.setId(pedidoDTO.getId());
		pedido.setNumPedido(pedidoDTO.getNumPedido());
		pedido.setDataPedido(pedidoDTO.getDataPedido());
		pedido.setStatus(pedidoDTO.getStatus());
		pedido.setCliente(serviceCli.getCliente(pedidoDTO.getClienteId()));
		
		
		
		Date dataEntrega = pedidoDTO.getDataPedido();
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(dataEntrega); 
		cal.add(Calendar.DATE, 15);
		dataEntrega = cal.getTime();
		pedido.setDataEntrega(dataEntrega);
		verificarExiste(pedido);
		

		pedido.getCliente().adicionarPedido(pedido);
		
		repositorio.save(pedido);
		
		
		pedido.setValorTotalPed(servicePedidoProduto.create(pedidoDTO.getProdutos(), pedido));
		repositorio.save(pedido);
		
	}

	public Pedido atualizar(String status, Integer id)
			throws PedidoInexistenteException, PedidoExistenteException {
		Optional<Pedido> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new PedidoInexistenteException("Pedido não cadastrado");
		}
		Pedido oldPedido = optional.get();
		if(oldPedido.getStatus() != null) {
			oldPedido.setStatus(status);
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
	
	public Integer getUserId(Integer id) {
		Optional<Pedido> optional = repositorio.findById(id);
		return optional.get().getCliente().getUsuario().getIdUsuario();
	}
}
