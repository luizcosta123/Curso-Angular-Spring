package com.luiz.os.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.luiz.os.model.Tecnico;

public class TecnicoDto implements Serializable {
	private static final long serialVersion = 1L;
	
	private Integer id;
	@NotEmpty(message = "O campo NAME é obrigatório!")
	private String name;
	@CPF
	@NotEmpty(message = "O campo CPF é obrigatório!")
	private String cpf;
	@NotEmpty(message = "O campo PHONE é obrigatório")
	private String phone;
	
	public TecnicoDto() {
		super();
	}

	public TecnicoDto(Tecnico tecnico) {
		super();
		this.id = tecnico.getId();
		this.name = tecnico.getName();
		this.cpf = tecnico.getCpf();
		this.phone = tecnico.getPhone();
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
