package com.caixaeletronico.demo.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.caixaeletronico.demo.model.Cliente;
import com.caixaeletronico.demo.model.ClientePF;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientePFServiceTest {
	
	@Mock
	private ClienteService  clienteService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deve_criar_novo_clientepf() {
		Cliente cliente = new Cliente(1L, "Jimmy Neutron", "jimmy@", "82729279");
			clienteService.criaCliente(cliente);
		ClientePF cpf = new ClientePF(1L, "26827872", "27/09/2809", "Itau", "27/09/2809", cliente);
			clienteService.criaClientePF(cpf, cliente);
				Assertions.assertThat(cpf.getId()).isEqualTo(1L);
				Assertions.assertThat(cpf.getCpf()).isEqualTo("26827872");
				Assertions.assertThat(cpf.getBanco()).isEqualTo("Itau");
				Assertions.assertThat(cpf.getDataAdesao()).isEqualTo("27/09/2809");
				Assertions.assertThat(cpf.getDataNascimento()).isEqualTo("27/09/2809");
				Assertions.assertThat(cliente.getId()).isEqualTo(1L);
				Assertions.assertThat(cliente.getNome()).isEqualTo("Jimmy Neutron");
				Assertions.assertThat(cliente.getEmail()).isEqualTo("jimmy@");
				Assertions.assertThat(cliente.getTelefone()).isEqualTo("82729279");
	}
	
	@Test
	public void deve_consultar_clientepf() {
		Cliente cliente = new Cliente(1L, "Jimmy Neutron", "jimmy@", "82729279");
		ClientePF cpf = new ClientePF(1L, "26827872", "27/09/2809", "Itau", "27/09/2809", cliente);
			clienteService.consultaCliente();
				Assertions.assertThat(cpf).isNotNull();
		
	}
	
	@Test
	public void deve_deletar_clientepf() {
		Cliente cliente = new Cliente(1L, "Jimmy Neutron", "jimmy@", "82729279");
		ClientePF cpf = new ClientePF(1L, "26827872", "27/09/2809", "Itau", "27/09/2809", cliente);
			cpf.equals(clienteService.consultaClientePFId(cpf.getId()));
			clienteService.deletarClientePF(cpf.getId());
				Assertions.assertThat(cpf.getId()).isEqualTo(1L);
	}
	
	@Test
	public void deve_consultar_clientepf_id() {
		Cliente cliente = new Cliente(1L, "Jimmy Neutron", "jimmy@", "82729279");
		ClientePF cpf = new ClientePF(1L, "26827872", "27/09/2809", "Itau", "27/09/2809", cliente);
				Assertions.assertThat(cpf.getId()).isEqualTo(1L);
	}
	
}
