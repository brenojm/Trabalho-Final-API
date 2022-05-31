package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Categoria;
import com.example.demo.model.Produto;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	Optional<Categoria> findByNome(String nome);
}
