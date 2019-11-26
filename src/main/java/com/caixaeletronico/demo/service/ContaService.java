package com.caixaeletronico.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.caixaeletronico.demo.model.Cliente;
import com.caixaeletronico.demo.model.ClientePF;
import com.caixaeletronico.demo.model.ClientePJ;
import com.caixaeletronico.demo.model.Conta;

@Service
public interface ContaService {
	
	void criaConta(Conta conta, Cliente cliente, ClientePF clientepf, ClientePJ clientepj);
	
	void alterarConta(Conta conta, ClientePF cpf, ClientePJ cpj, Long id);
	
	Conta consultaContaId(Long id);
	
	Conta deletarContaId(Long id);
	
	List<Conta> consultaConta();
	
	List<Conta> verificaConta(Cliente cliente);
	
	
}
