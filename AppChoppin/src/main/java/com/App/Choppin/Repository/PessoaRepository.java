package com.App.Choppin.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.App.Choppin.models.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

	Pessoa findById(long id);
	Pessoa findByNome(String nome);
	
	// Query para a busca
	@Query(value = "select u from Pessoa u where u.nome like %?1%")
	List<Pessoa>findByNomes(String nome);
}
