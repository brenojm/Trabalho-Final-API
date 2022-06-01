package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Integer>{

}
