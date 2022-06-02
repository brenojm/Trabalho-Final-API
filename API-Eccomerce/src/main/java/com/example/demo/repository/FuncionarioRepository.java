package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Integer>{
	
	Optional<Funcionario> findByIdFuncionario(Integer idFuncionario);
}
