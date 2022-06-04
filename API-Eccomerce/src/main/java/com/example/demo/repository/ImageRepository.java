package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Image;

public interface ImageRepository  extends JpaRepository<Image, Integer>{

	Optional<Image> findByProdutoId(Integer id);

}
