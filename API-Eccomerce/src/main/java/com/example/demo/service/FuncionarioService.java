package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.MailConfig;
import com.example.demo.exception.FuncionarioExistenteException;
import com.example.demo.exception.FuncionarioInexistenteException;
import com.example.demo.exception.UsuarioInexistenteException;
import com.example.demo.model.Funcionario;
import com.example.demo.model.Usuario;
import com.example.demo.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository repositorio;
	
	@Autowired
	UsuarioService serviceUsuario;
	
	@Autowired
	MailConfig mailConfig;
	
	@Autowired
	BCryptPasswordEncoder bCrypt;

	public List<Funcionario> listarTudo() {
		return repositorio.findAll();
	}

	public Funcionario listarPorCpf(String cpf) {
		Optional<Funcionario> funcionario = repositorio.findByCpf(cpf);
		return funcionario.get();
	}

	public Funcionario create(Funcionario funcionario) throws FuncionarioExistenteException, UsuarioInexistenteException {
		
		Usuario usuario = funcionario.getUsuario();
		usuario.setRole("f");
		verificarExiste(funcionario);
		usuario.setSenha(bCrypt.encode(usuario.getSenha()));
		serviceUsuario.saveUsuario(usuario);
//		mailConfig.sendEmail(null, usuario.getEmail(), "Ativar Conta", "Ative sua conta no link abaixo:");
		return repositorio.save(funcionario);
		
		
	}

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
		}
		if (funcionario.getTelefone() != null) {
			if (!funcionario.getTelefone().equals("")) {
				oldFuncionario.setTelefone(funcionario.getTelefone());
			}
		}
		return repositorio.save(oldFuncionario);
	}
	


	private void verificarExiste(Funcionario funcionario) throws FuncionarioExistenteException {
		Optional<Funcionario> optional = repositorio.findByIdFuncionario(funcionario.getIdFuncionario());
		if (optional.isPresent()) {
			throw new FuncionarioExistenteException("Funcionario já existe");
		}

	}

	public void delete(Integer id) {
		repositorio.deleteById(id);
	}
	
	public Funcionario listarPorId(Integer id) {
		Optional<Funcionario> optional = repositorio.findByIdFuncionario(id);
		return optional.get();
	}

}