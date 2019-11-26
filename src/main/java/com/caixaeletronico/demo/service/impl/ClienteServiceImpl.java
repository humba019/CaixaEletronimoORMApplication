package com.caixaeletronico.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caixaeletronico.demo.model.Cliente;
import com.caixaeletronico.demo.model.ClientePF;
import com.caixaeletronico.demo.model.ClientePJ;
import com.caixaeletronico.demo.repository.ClientePFRepository;
import com.caixaeletronico.demo.repository.ClienteRepository;
import com.caixaeletronico.demo.service.ClienteService;
//import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	ClienteRepository cr;
	
	@Autowired
	ClientePFRepository cpfr;
	
	
	@Override
	public ClientePF criaClientePF(ClientePF cpf, Cliente cliente) {
		return cr.criaClientePF(cpf.getBanco(), cpf.getCpf(), cpf.getDataNascimento(), cpf.getDataAdesao(), cliente);
	}

	@Override
	public void criaClientePJ(ClientePJ cpj, Cliente cliente) {
		cr.criaClientePJ(cpj.getBanco(), cpj.getCnpj(), cpj.getDataAbertura(), cpj.getDataAdesao(), cliente);
	}

	@Override
	public Cliente criaCliente(Cliente cliente) {
		return cr.save(cliente);
	}

	@Override
	public List<Cliente> consultaCliente() {
		return cr.findAll();
	}

	@Override
	public Cliente deletarCliente(Long id) {
		Optional<Cliente> c = cr.findById(id);
		cr.delete(c.get());
		return c.get();
	}

	@Override
	public Cliente alterarCliente(Cliente cliente, Long id) {
		return cr.alterarCliente(cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), id);
	}

	@Override
	public void alterarClientePF(ClientePF cpf, Long id) {
		cr.alterarClientePF(cpf.getCpf(), cpf.getDataNascimento(), cpf.getDataAdesao(), cpf.getBanco(), id);
	}

	@Override
	public void alterarClientePJ(ClientePJ cpj, Long id) {
		cr.alterarClientePJ(cpj.getCnpj(), cpj.getDataAbertura(), cpj.getDataAdesao(), cpj.getBanco(), id);
	}

	@Override
	public Long consultaClienteId(Cliente cliente) {
		Optional<Cliente> c = cr.findById(cliente.getId());
		return c.get().getId();
	}

	@Override
	public List<ClientePF> verificaClientePF(Cliente cliente) {
		return cr.verificaClientePF(cliente);
	}

	@Override
	public List<ClientePJ> verificaClientePJ(Cliente cliente) {
		return cr.verificaClientePJ(cliente);
	}

	@Override
	public ClientePF deletarClientePF(Long id) {
		Optional<ClientePF> cpf = cpfr.findById(id);
		cpfr.delete(cpf.get());
		return cpf.get();
	}

	@Override
	public ClientePF consultaClientePFId(Long id) {
		Optional<ClientePF> c = cpfr.findById(id); 
		return c.get();
	}

	@Override
	public List<ClientePF> consultaClientePF() {
		return cpfr.findAll();
	}


}
