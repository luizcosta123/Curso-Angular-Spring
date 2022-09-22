package com.luiz.os.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.os.exception.ObjectNotFoundException;
import com.luiz.os.model.Cliente;
import com.luiz.os.model.Tecnico;
import com.luiz.os.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente findById(Integer id) {
		
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"
				   												   + " / Id: " + id
				   												   + " / Tipo: " + Cliente.class.getName()));
		
	}

}
