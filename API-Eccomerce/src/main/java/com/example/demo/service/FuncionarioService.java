package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.FuncionarioExistenteException;
import com.example.demo.exception.FuncionarioInexistenteException;
import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository repositorio;

	public List<Funcionario> listarTudo() {
		return repositorio.findAll();
	}

	public Funcionario listarPorId(Integer id) {
		System.out.println(id);
		Optional<Funcionario> funcionario = repositorio.findByIdFuncionario(id);
		return funcionario.get();
	}

	public Funcionario create(Funcionario funcionario) throws FuncionarioExistenteException {
		verificarExiste(funcionario);
		return repositorio.save(funcionario);
	}

	// Realizar tratamentos conforme exemplo no 'ProdutoService'
	public Funcionario update(Funcionario funcionario, Integer id)
			throws FuncionarioInexistenteException, FuncionarioExistenteException {
		Optional<Funcionario> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new FuncionarioInexistenteException("Funcionario não cadastrado");
		}
		Funcionario oldFuncionario = optional.get();
		if (funcionario.getNome() != null) {
			if (!funcionario.getNome().equals("")) {
				verificarExiste(funcionario);
				oldFuncionario.setNome(funcionario.getNome());
			}
			// CPF aqui (?)
		}
		if (funcionario.getTelefone() != null) {
			if (!funcionario.getTelefone().equals("")) {
				oldFuncionario.setTelefone(funcionario.getTelefone());
			}
			// Data de nascimento (?)
		}
		return repositorio.save(oldFuncionario);
	}
	

	private void verificarExiste(Funcionario funcionario) throws FuncionarioExistenteException {
		Optional<Funcionario> optional = repositorio.findByIdFuncionario(funcionario.getIdFuncionario());
		if (optional.isPresent()) {
			throw new FuncionarioExistenteException("Funcionario já existe");
		}
		repositorio.save(funcionario);

	}

	public void delete(Integer id) {
		repositorio.deleteById(id);
	}

}