package com.caixaeletronico.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "conta")
public class Conta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_conta")
	@SequenceGenerator(allocationSize = 1, name = "seq_conta", sequenceName = "seq_conta")
	@Column(name = "idconta")
	private Long id;

	@Column(name = "agencia")
	private String agencia;

	@Column(name = "numero")
	private String numero;
	
	@Column(name = "tipo")
	private String tipo;

	@Column(name = "saldo")
	private String saldo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idcliente")
	private Cliente cliente;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idclientepf")
	private ClientePF clientepf;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idclientepj")
	private ClientePJ clientepj;

	public Conta() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClientePF getClientepf() {
		return clientepf;
	}

	public void setClientepf(ClientePF clientepf) {
		this.clientepf = clientepf;
	}

	public ClientePJ getClientepj() {
		return clientepj;
	}

	public void setClientepj(ClientePJ clientepj) {
		this.clientepj = clientepj;
	}

	
	
	

}
