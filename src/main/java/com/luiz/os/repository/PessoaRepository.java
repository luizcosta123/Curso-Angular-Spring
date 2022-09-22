package com.luiz.os.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luiz.os.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	
	Pessoa findByCpf(String cpf);

}
