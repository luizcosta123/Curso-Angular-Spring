package com.luiz.os.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa {
	
	@OneToMany(mappedBy = "cliente")
	private List<OrdemServico> ordemServicoList = new ArrayList<>();

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String name, String cpf, String phone) {
		super(id, name, cpf, phone);
	}

	public List<OrdemServico> getOrdemServicoList() {
		return ordemServicoList;
	}

	public void setOrdemServicoList(List<OrdemServico> ordemServicoList) {
		this.ordemServicoList = ordemServicoList;
	}

}
