package com.caixaeletronico.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caixaeletronico.demo.model.Cliente;
import com.caixaeletronico.demo.model.ClientePF;
import com.caixaeletronico.demo.model.ClientePJ;
import com.caixaeletronico.demo.model.Conta;
import com.caixaeletronico.demo.repository.ContaRepository;
import com.caixaeletronico.demo.service.ContaService;

@Service
public class ContaServiceImpl implements ContaService{
	
	@Autowired
	ContaRepository cr;

	@Override
	public void criaConta(Conta conta, Cliente cliente, ClientePF clientepf, ClientePJ clientepj) {
		cr.criaConta(conta.getAgencia(), conta.getNumero(), conta.getTipo(), conta.getSaldo(), cliente, clientepf, clientepj);
	}

	@Override
	public Conta consultaContaId(Long id) {
		Optional<Conta> c = cr.findById(id);
		return c.get();
	}

	@Override
	public Conta deletarContaId(Long id) {
		Optional<Conta> c = cr.findById(id);
		cr.deleteById(id);
		return c.get();
	}

	@Override
	public List<Conta> consultaConta() {
		return cr.findAll();
	}

	@Override
	public List<Conta> verificaConta(Cliente cliente) {
		return cr.verificaConta(cliente);
	}

	@Override
	public void alterarConta(Conta conta, ClientePF cpf, ClientePJ cpj, Long id) {
		cr.alterarConta(conta.getAgencia(), conta.getNumero(), conta.getTipo(), conta.getSaldo(), cpf, cpj, id);
	}

}
