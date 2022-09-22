package com.luiz.os.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luiz.os.dto.ClienteDto;
import com.luiz.os.service.ClienteService;

@RestController()
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> findById(@PathVariable Integer id) {
		ClienteDto clienteDto = new ClienteDto(clienteService.findById(id));
		
		return ResponseEntity.ok().body(clienteDto);
	}

}
