package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco,Integer>{

	Optional<Endereco> findByCep(String cep);
}
