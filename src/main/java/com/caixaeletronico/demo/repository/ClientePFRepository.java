package com.caixaeletronico.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caixaeletronico.demo.model.ClientePF;

@Repository
public interface ClientePFRepository extends JpaRepository<ClientePF, Long> {}
