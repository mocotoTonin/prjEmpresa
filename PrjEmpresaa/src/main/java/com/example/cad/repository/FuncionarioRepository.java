package com.example.cad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cad.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
