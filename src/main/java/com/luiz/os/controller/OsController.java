package com.luiz.os.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luiz.os.dto.OsDto;
import com.luiz.os.model.Os;
import com.luiz.os.service.OsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/os")
public class OsController {
	
	@Autowired
	private OsService osService;
	
	@GetMapping("/{id}")
	public ResponseEntity<OsDto> findById(@PathVariable Integer id) {
		OsDto osDto = new OsDto(osService.findById(id));
		
		return ResponseEntity.ok().body(osDto);
	}
	
	@GetMapping()
	public ResponseEntity<List<OsDto>> findAll() {
		List<OsDto> osDtosList = osService.findAll().stream().map(os -> new OsDto(os)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(osDtosList);
	}
	
	@PostMapping()
	public ResponseEntity<OsDto> create(@Valid @RequestBody OsDto osDto) {
		osDto = new OsDto(osService.create(osDto));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(osDto.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping()
	public ResponseEntity<OsDto> update(@Valid @RequestBody OsDto osDto) {
		osDto = new OsDto(osService.update(osDto));
		
		return ResponseEntity.ok().body(osDto);
	}

}















