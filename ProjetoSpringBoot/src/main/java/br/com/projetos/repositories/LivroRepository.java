package br.com.projetos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetos.classes.Genero;
import br.com.projetos.classes.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	
	List<Livro> findByGenero(Genero genero);

}
