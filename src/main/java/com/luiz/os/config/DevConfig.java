package com.luiz.os.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.luiz.os.enuns.Prioridade;
import com.luiz.os.enuns.Status;
import com.luiz.os.model.Cliente;
import com.luiz.os.model.Os;
import com.luiz.os.model.Tecnico;
import com.luiz.os.repository.ClienteRepository;
import com.luiz.os.repository.OsRepository;
import com.luiz.os.repository.TecnicoRepository;
import com.luiz.os.service.DbService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DbService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;
	
	@Bean
	public boolean instanciaDb() {
		
		if(ddl.equals("create-drop")) {
			dbService.instanciaDb();
		}
		
		return false;
		
	}

}
