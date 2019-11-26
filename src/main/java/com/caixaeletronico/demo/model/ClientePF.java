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
@Table(name = "clientepf")
public class ClientePF implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_clientepf")
	@SequenceGenerator(allocationSize = 1, name = "seq_clientepf", sequenceName = "seq_clientepf")
	@Column(name="idclientepf")
	private Long id;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "dataNascimento")
	private String dataNascimento;
	
	@Column(name = "banco")
	private String banco;

	@Column(name = "dataAdesao")
	private String dataAdesao;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idcliente")
	private Cliente cliente;
	
	public ClientePF() {}
	
	public ClientePF(Long id, String cpf, String dataNascimento, String banco, String dataAdesao, Cliente cliente) {
		this.id = id;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.banco = banco;
		this.dataAdesao = dataAdesao;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getDataAdesao() {
		return dataAdesao;
	}

	public void setDataAdesao(String dataAdesao) {
		this.dataAdesao = dataAdesao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
