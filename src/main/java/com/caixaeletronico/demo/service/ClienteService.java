package com.caixaeletronico.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.caixaeletronico.demo.model.Cliente;
import com.caixaeletronico.demo.model.ClientePF;
import com.caixaeletronico.demo.model.ClientePJ;

@Service
public interface ClienteService {
	
	Cliente criaCliente(Cliente cliente);
	
	List<Cliente> consultaCliente();
	
	Long consultaClienteId(Cliente cliente);
	
	Cliente deletarCliente(Long id);
	
	void alterarClientePF(ClientePF cpf, Long id);
	
	void alterarClientePJ(ClientePJ cpj, Long id);
	
	Cliente alterarCliente(Cliente cliente, Long id);

	ClientePF criaClientePF(ClientePF cpf, Cliente cliente);
	
	void criaClientePJ(ClientePJ cpj, Cliente cliente);
	
	List<ClientePF> verificaClientePF(Cliente cliente);
	
	List<ClientePJ> verificaClientePJ(Cliente cliente);
	
	ClientePF deletarClientePF(Long id);
	
	ClientePF consultaClientePFId(Long id);
	
	List<ClientePF> consultaClientePF();
}
