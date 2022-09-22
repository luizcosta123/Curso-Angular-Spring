package com.luiz.os.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.luiz.os.enuns.Prioridade;
import com.luiz.os.enuns.Status;
import com.luiz.os.model.Cliente;
import com.luiz.os.model.OrdemServico;
import com.luiz.os.model.Tecnico;
import com.luiz.os.repository.ClienteRepository;
import com.luiz.os.repository.OrdemServicoRepository;
import com.luiz.os.repository.TecnicoRepository;
import com.luiz.os.service.DbService;

@Configuration
@Profile("test")
public class testeConfig {
	
	@Autowired
	private DbService dbService;
	
	@Bean
	public void instanciaDb() {
		dbService.instanciaDb();
	}

}
