package com.luiz.os.service;

import java.util.List;
import java.util.Optional;

import com.luiz.os.exception.DataIntegrityViolationException;
import com.luiz.os.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.os.dto.TecnicoDto;
import com.luiz.os.exception.ObjectNotFoundException;
import com.luiz.os.model.Tecnico;
import com.luiz.os.repository.TecnicoRepository;

import javax.validation.Valid;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	public Tecnico findById(Integer id) {
		
		Optional<Tecnico> tecnico = tecnicoRepository.findById(id);
		
		return tecnico.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"
																   + " / Id: " + id
																   + " / Tipo: " + Tecnico.class.getName()));
		
	}

	public List<Tecnico> findAll() {
		return tecnicoRepository.findAll();
	}
	
	public Tecnico create(TecnicoDto tecnicoDto) {
		if(findByCpf(tecnicoDto) != null) {
			throw new DataIntegrityViolationException("CPF já cadastrado no banco de dados!");
		}

		return tecnicoRepository.save(new Tecnico(null, tecnicoDto.getName(), tecnicoDto.getCpf(), tecnicoDto.getPhone()));
	}

    public Tecnico update(Integer id, @Valid TecnicoDto tecnicoDto) {
		Tecnico oldTecnico = findById(id);

		if(findByCpf(tecnicoDto) != null && findByCpf(tecnicoDto).getId() != id) {
			return tecnicoRepository.save(new Tecnico(null, tecnicoDto.getName(), tecnicoDto.getCpf(), tecnicoDto.getPhone()));
		}

		oldTecnico.setName(tecnicoDto.getName());
		oldTecnico.setCpf(tecnicoDto.getCpf());
		oldTecnico.setPhone(tecnicoDto.getPhone());

		return tecnicoRepository.save(oldTecnico);
    }

	public void delete(Integer id) {
		Tecnico tecnico = findById(id);

		if(tecnico.getOrdemServicoList().size() > 0) {
			throw new DataIntegrityViolationException("Técnico possui Ordens de Serviço, não pode ser deletado!");
		}

		tecnicoRepository.deleteById(id);
	}

	public Pessoa findByCpf(TecnicoDto tecnicoDto) {
		Pessoa tecnico = tecnicoRepository.findByCpf(tecnicoDto.getCpf());

		if(tecnico != null) {
			return tecnico;
		}

		return null;
	}

}
