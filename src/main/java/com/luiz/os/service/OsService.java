package com.luiz.os.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.os.dto.OsDto;
import com.luiz.os.enuns.Prioridade;
import com.luiz.os.enuns.Status;
import com.luiz.os.exception.ObjectNotFoundException;
import com.luiz.os.model.Cliente;
import com.luiz.os.model.Os;
import com.luiz.os.repository.OsRepository;

@Service
public class OsService {
	
	@Autowired
	private OsRepository osRepository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public Os findById(Integer id) {
		Optional<Os> ordemServico = osRepository.findById(id);
		
		return ordemServico.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"
				   														+ " / Id: " + id
				   														+ " / Tipo: " + Os.class.getName()));
	}
	
	public List<Os> findAll() {
		return osRepository.findAll();
	}

	public Os create(@Valid OsDto osDto) {
		return fromDto(osDto);
	}
	
	public Os update(@Valid OsDto osDto) {
		findById(osDto.getId());
		return fromDto(osDto);
	}
	
	public Os fromDto(OsDto osDto) {
		Os os = new Os();
		
		os.setId(osDto.getId());
		os.setObservacoes(osDto.getObservacoes());
		os.setPrioridade(Prioridade.toEnum(osDto.getPrioridade()));
		os.setStatus(Status.toEnum(osDto.getStatus()));
		os.setTecnico(tecnicoService.findById(osDto.getTecnico()));
		os.setCliente(clienteService.findById(osDto.getCliente()));
		
		if(os.getStatus().getKey().equals(2)) {
			os.setDataFechamento(LocalDateTime.now());
		}
		
		return osRepository.save(os);
	}

}
