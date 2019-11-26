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

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	@Transactional
	@Modifying
	@Query("UPDATE Cliente c SET c.nome = :nome, c.email = :email, c.telefone = :telefone WHERE c.id = :id")
	Cliente alterarCliente(@Param("nome") String nome, @Param("email") String email, @Param("telefone") String telefone, @Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query("UPDATE ClientePF cpf SET cpf.cpf = :cpf, cpf.dataNascimento = :dataNascimento, cpf.dataAdesao = :dAdesao, cpf.banco = :banco WHERE id = :id")
	void alterarClientePF(@Param("cpf") String cpf,@Param("dataNascimento") String dataNascimento,@Param("dAdesao") String dataAdesao,@Param("banco") String banco,@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query("UPDATE ClientePJ cpj SET cpj.cnpj = :cnpj, cpj.dataAbertura = :dAbertura, cpj.dataAdesao = :dAdesao, cpj.banco = :banco WHERE id = :id")
	void alterarClientePJ(@Param("cnpj") String cnpj,@Param("dAbertura") String dataAbertura,@Param("dAdesao") String dataAdesao,@Param("banco") String banco,@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query("INSERT INTO ClientePF (banco,cpf,dataNascimento,dataAdesao,cliente) SELECT :banco, :cpf, :dataNascimento, :dataAdesao, :cliente FROM Cliente WHERE idcliente = :cliente")
	ClientePF criaClientePF(@Param("banco") String banco, @Param("cpf") String cpf, @Param("dataNascimento") String dataNascimento, @Param("dataAdesao") String dataAdesao, @Param("cliente") Cliente cliente);

	@Transactional
	@Modifying
	@Query("INSERT INTO ClientePJ (banco,cnpj,dataAbertura,dataAdesao,cliente) SELECT :banco, :cnpj, :dataAbertura, :dataAdesao, :cliente FROM Cliente WHERE idcliente = :cliente")
	void criaClientePJ(@Param("banco") String banco, @Param("cnpj") String cnpj, @Param("dataAbertura") String dataAbertura, @Param("dataAdesao") String dataAdesao, @Param("cliente") Cliente cliente);
	
	
	@Transactional
	@Modifying
	@Query("SELECT c FROM ClientePF c WHERE c.cliente  = :cliente")
	List<ClientePF> verificaClientePF(@Param("cliente") Cliente cliente);

	@Transactional
	@Modifying
	@Query("SELECT c FROM ClientePJ c WHERE c.cliente  = :cliente")
	List<ClientePJ> verificaClientePJ(@Param("cliente") Cliente cliente);
}
