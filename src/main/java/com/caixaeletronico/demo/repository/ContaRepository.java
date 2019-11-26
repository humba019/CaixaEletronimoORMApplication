package com.caixaeletronico.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.caixaeletronico.demo.model.Cliente;
import com.caixaeletronico.demo.model.ClientePF;
import com.caixaeletronico.demo.model.ClientePJ;
import com.caixaeletronico.demo.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
	
	@Transactional
	@Modifying
	@Query("INSERT INTO Conta (agencia,numero,tipo,saldo,cliente, clientepf, clientepj) SELECT :agencia, :numero, :tipo, :saldo, :cliente, :clientepf, :clientepj FROM Cliente WHERE idcliente = :cliente")
	void criaConta(@Param("agencia") String agencia, @Param("numero") String numero, @Param("tipo") String tipo, @Param("saldo") String saldo, @Param("cliente") Cliente cliente,  @Param("clientepf") ClientePF clientepf,  @Param("clientepj") ClientePJ clientepj);
	
	@Transactional
	@Modifying
	@Query("SELECT c FROM Conta c WHERE c.cliente = :cliente")
	List<Conta> verificaConta(@Param("cliente") Cliente cliente);
	
	@Transactional
	@Modifying
	@Query("UPDATE Conta c SET c.agencia = :agencia, c.numero = :numero, c.tipo = :tipo, c.saldo = :saldo, c.clientepf = :clientepf, c.clientepj = :clientepj WHERE c.id = :id")
	void alterarConta(@Param("agencia") String agencia, @Param("numero") String numero, @Param("tipo") String tipo, @Param("saldo") String saldo,@Param("clientepf") ClientePF cpf, @Param("clientepj") ClientePJ cpj, @Param("id") Long id);
	
}
