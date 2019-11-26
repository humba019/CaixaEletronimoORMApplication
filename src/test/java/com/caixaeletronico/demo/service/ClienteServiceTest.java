package com.caixaeletronico.demo.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.caixaeletronico.demo.model.Cliente;
import com.caixaeletronico.demo.service.impl.ClienteServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteServiceTest {
			
	@Mock
	ClienteService clienteService;
	
	@InjectMocks
	ClienteServiceImpl clienteServiceImpl;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);		
	}
	
	@Test
	public void deve_cria_novo_cliente() {
		Cliente cliente = new Cliente(1L, "Mario do Nintendinho 64", "mario@", "40028922");
			clienteService.criaCliente(cliente);
				Assertions.assertThat(cliente.getId()).isEqualTo(1L);
				Assertions.assertThat(cliente.getNome()).isEqualTo("Mario do Nintendinho 64");
				Assertions.assertThat(cliente.getEmail()).isEqualTo("mario@");
				Assertions.assertThat(cliente.getTelefone()).isEqualTo("40028922");
		
	}
	
	@Test
	public void deve_consultar_cliente() {
		Cliente cliente = new Cliente(1L, "Mario do Nintendinho 64", "mario@", "40028922");
		clienteService.consultaCliente();
			Assertions.assertThat(cliente).isNotNull();
		
	}
	
	@Test
	public void deve_deletar_cliente() {
	Cliente cliente = new Cliente(1L, "Mario do Nintendinho 64", "mario@", "40028922");
	clienteService.criaCliente(cliente);
		Long c = clienteService.consultaClienteId(cliente);
		cliente  = clienteService.deletarCliente(c);
			Assertions.assertThat(cliente).isNull();
	}
	
	@Test
	public void deve_consultar_cliente_id() {
	Cliente cliente = new Cliente(1L, "Mario do Nintendinho 64", "mario@", "40028922");
		clienteService.criaCliente(cliente);
		Long c = clienteService.consultaClienteId(cliente);
			Assertions.assertThat(c).isNotNull();
		
	}
	
	@Test
	public void deve_alterar_cliente() {
	Cliente cliente = new Cliente(1L, "Mario do Nintendinho 64", "mario@", "40028922");
		clienteService.criaCliente(cliente);
		Long c =  clienteService.consultaClienteId(cliente);
		cliente  = new Cliente(cliente.getId(), "", "", "");
		clienteService.alterarCliente(cliente, c);
			Assertions.assertThat(cliente.getId()).isNotNull();
			Assertions.assertThat(cliente.getNome()).isEqualTo("");
			Assertions.assertThat(cliente.getEmail()).isEqualTo("");
			Assertions.assertThat(cliente.getTelefone()).isEqualTo("");
	}
}
