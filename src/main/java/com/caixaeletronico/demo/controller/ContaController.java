package com.caixaeletronico.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caixaeletronico.demo.model.Cliente;
import com.caixaeletronico.demo.model.ClientePF;
import com.caixaeletronico.demo.model.ClientePJ;
import com.caixaeletronico.demo.model.Conta;
import com.caixaeletronico.demo.service.ClienteService;
import com.caixaeletronico.demo.service.ContaService;

@RestController
@RequestMapping("/")
public class ContaController {
	
	@Autowired
	ContaService cs;
	
	@Autowired
	ClienteService clis;	
	
	
	//Verificacao: ids de clientes vinculados a cpfs
//	@GetMapping("cliente/pf/{cliente}")
//	public List<ClientePF> verificaClientePF(@PathVariable(value = "cliente") Long cliente) {
//		Cliente c = clis.consultaClienteId(cliente);
//		return clis.verificaClientePF(c);
//	}
	
	@PostMapping("conta/novo/{cliente}")
	public void criaConta(@PathVariable(value = "cliente") Long cliente, @RequestBody Conta conta) {
		Cliente c = clis.consultaClienteId(cliente);
		if(cs.verificaConta(c).size()==0) {
			
			if(clis.verificaClientePF(c).size()==1 && clis.verificaClientePJ(c).size()==0) { 
				ClientePF cpf = clis.verificaClientePF(c).get(0);
				cs.criaConta(conta, c, cpf, null);
			}else {
				
				if(clis.verificaClientePF(c).size()==0 && clis.verificaClientePJ(c).size()==1) {
					ClientePJ cnpj = clis.verificaClientePJ(c).get(0);
					cs.criaConta(conta, c, null, cnpj);
				}else {
					
					if(clis.verificaClientePF(c).size()==1 && clis.verificaClientePJ(c).size()==1) {
						ClientePF cpf = clis.verificaClientePF(c).get(0);
						ClientePJ cnpj = clis.verificaClientePJ(c).get(0);
						cs.criaConta(conta, c, cpf, cnpj);
					}else {
						cs.criaConta(conta = new Conta(), null, null, null);
					}
				}
			}			
		}else {

			cs.criaConta(conta = new Conta(), null, null, null);
		}
		
	}
	
	@PostMapping("conta/alterar/{idcon}/{idcli}")
	public void alterarConta(@PathVariable(value= "idcon") Long idcon, @RequestBody Conta conta, @PathVariable("idcli") Long idcli) {
		Cliente cli = clis.consultaClienteId(idcli);
		List<ClientePF> cpf = clis.verificaClientePF(cli);
		List<ClientePJ> cpj = clis.verificaClientePJ(cli);
		cs.alterarConta(conta, cpf.get(0), cpj.get(0), idcon);	
	}
	
	@PostMapping("cliente/pf/novo/{cliente}")
	public void criaClientePF(@PathVariable(value = "cliente") Long cliente, @RequestBody ClientePF clientepf) {
		Cliente c = clis.consultaClienteId(cliente);
		if (clis.verificaClientePF(c).size()==1) { clis.criaClientePF(clientepf = new ClientePF(), null);}			
		else { clis.criaClientePF(clientepf, c);}
	}

	@PostMapping("cliente/pj/novo/{cliente}")
	public void criaClientePJ(@PathVariable(value = "cliente") Long cliente, @RequestBody ClientePJ clientepj) {
		
		Cliente c = clis.consultaClienteId(cliente);
		if (clis.verificaClientePJ(c).size()==1) { clis.criaClientePJ(clientepj = new ClientePJ(), null);}			
		else { clis.criaClientePJ(clientepj, c);}
		
	}
	
	@PostMapping("cliente/novo")
	public Cliente criaCliente(@RequestBody Cliente cliente) {
		return clis.criaCliente(cliente);
	}
	@GetMapping("cliente/consulta")
	public List<Cliente> consultaCliente(){
		return clis.consultaCliente();
	}
	@PostMapping("cliente/pf/alterar/{id}")
	public void alterarClientePF(@PathVariable(value = "id") Long id, @RequestBody ClientePF cpf) {
		clis.alterarClientePF(cpf, id);
	}
	@PostMapping("cliente/pj/alterar/{id}")
	public void alterarClientePJ(@PathVariable(value = "id") Long id, @RequestBody ClientePJ cpj) {
		clis.alterarClientePJ(cpj, id);
	}
	
	@PostMapping("cliente/alterar/{id}")
	public void alterarCliente(@PathVariable(name = "id") Long id, @RequestBody Cliente cliente) {
		clis.alterarCliente(cliente, id);
	}
	
	@DeleteMapping("cliente/deletar/{id}")
	public void deletarCliente(@PathVariable(value = "id") Long id) {
		Cliente c =  clis.consultaClienteId(id);
		clis.deletarCliente(c);
	}
	
}
