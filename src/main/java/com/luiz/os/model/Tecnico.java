package com.luiz.os.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tecnico extends Pessoa implements Serializable {
	private static final long serialVersion = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tecnico")
	private List<OrdemServico> ordemServicoList = new ArrayList<>();

	public Tecnico() {
		super();
	}

	public Tecnico(Integer id, String name, String cpf, String phone) {
		super(id, name, cpf, phone);
	}

	public List<OrdemServico> getOrdemServicoList() {
		return ordemServicoList;
	}

	public void setOrdemServicoList(List<OrdemServico> ordemServicoList) {
		this.ordemServicoList = ordemServicoList;
	}

}
