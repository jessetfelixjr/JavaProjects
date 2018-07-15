package br.com.projetos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.projetos.classes.Contato;

public interface ContatoRepository extends CrudRepository<Contato, Long> {
	
	 List<Contato> findByNome(String nome);

}
