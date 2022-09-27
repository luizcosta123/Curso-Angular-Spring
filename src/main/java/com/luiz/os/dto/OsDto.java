package com.luiz.os.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luiz.os.model.Os;

public class OsDto implements Serializable {
	
	private static final long serialVersion = 1L;
	
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:MM")
	private LocalDateTime dataAbertura;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:MM")
	private LocalDateTime dataFechamento;
	
	private Integer prioridade;
	
	@NotEmpty(message = "O campo OBSERVAÇÕES é requerido!")
	private String observacoes;
	
	private Integer status;
	private Integer tecnico;
	private Integer cliente;
	
	public OsDto() {
		super();
	}

	public OsDto(Os os) {
		super();
		this.id = os.getId();
		this.dataAbertura = os.getDataAbertura();
		this.dataFechamento = os.getDataFechamento();
		this.prioridade = os.getPrioridade().getKey();
		this.observacoes = os.getObservacoes();
		this.status = os.getStatus().getKey();
		this.tecnico = os.getTecnico().getId();
		this.cliente = os.getCliente().getId();
	}
	
	public Integer getId() {
		return id;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTecnico() {
		return tecnico;
	}

	public void setTecnico(Integer tecnico) {
		this.tecnico = tecnico;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}
	
}
