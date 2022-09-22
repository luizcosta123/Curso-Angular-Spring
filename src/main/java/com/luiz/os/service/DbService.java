package com.luiz.os.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.luiz.os.enuns.Prioridade;
import com.luiz.os.enuns.Status;
import com.luiz.os.model.Cliente;
import com.luiz.os.model.OrdemServico;
import com.luiz.os.model.Tecnico;
import com.luiz.os.repository.ClienteRepository;
import com.luiz.os.repository.OrdemServicoRepository;
import com.luiz.os.repository.TecnicoRepository;

@Service
public class DbService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	public void instanciaDb() {
		Tecnico t1 = new Tecnico(null, "t1", "590.359.210-46", "(15) 92341-1234");
		Tecnico t2 = new Tecnico(null, "t2", "358.198.860-70", "(15) 91232-3333");
		Cliente c1 = new Cliente(null, "c1", "997.511.350-87", "(15) 93122-9998");
		
		OrdemServico os1 = new OrdemServico(null, Prioridade.ALTA, "Teste - criando OS", Status.ANDAMENTO, t1, c1);
		
		t1.getOrdemServicoList().add(os1);
		c1.getOrdemServicoList().add(os1);
		
		tecnicoRepository.saveAll(Arrays.asList(t1, t2));
		clienteRepository.saveAll(Arrays.asList(c1));
		ordemServicoRepository.saveAll(Arrays.asList(os1));
	}

}
