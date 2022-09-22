package com.luiz.os.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.luiz.os.model.Cliente;

public class ClienteDto implements Serializable {
	
	private static final long serialVersion = 1L;
	
	private Integer id;
	@NotEmpty(message = "O campo NAME é obrigatório!")
	private String name;
	@CPF
	@NotEmpty(message = "O campo CPF é obrigatório!")
	private String cpf;
	@NotEmpty(message = "O campo PHONE é obrigatório")
	private String phone;
	
	public ClienteDto() {
		super();
	}

	public ClienteDto(Cliente cliente) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
