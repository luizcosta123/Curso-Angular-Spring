package com.luiz.os;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luiz.os.enuns.Prioridade;
import com.luiz.os.enuns.Status;
import com.luiz.os.model.Cliente;
import com.luiz.os.model.Os;
import com.luiz.os.model.Tecnico;
import com.luiz.os.repository.ClienteRepository;
import com.luiz.os.repository.OsRepository;
import com.luiz.os.repository.TecnicoRepository;

@SpringBootApplication
public class OsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OsApplication.class, args);
	}

}
