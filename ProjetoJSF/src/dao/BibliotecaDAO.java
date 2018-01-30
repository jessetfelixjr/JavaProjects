package dao;

import java.util.ArrayList;
import java.util.List;

import classes.Genero;
import classes.Livro;
import enums.GeneroEnum;

public class BibliotecaDAO extends PadraoDAO {
	
	private List<Livro> livros = new ArrayList<Livro>();
	private List<Genero> generos = new ArrayList<Genero>();
	
	public BibliotecaDAO() {
		generos = buscarGeneros();
		livros.add(new Livro(1, "J.K. Rowling", "Harry Potter", generos.get(0)));
		livros.add(new Livro(2, "William P. Young", "A Cabana", generos.get(1)));
		livros.add(new Livro(3, "Markus Zusak", "A Menina que Roubava Livros", generos.get(0)));
		livros.add(new Livro(4, "C. S. Lewis", "As Crônicas de Narnia", generos.get(1)));
	}

	public List<Genero> buscarGeneros() {
		
		List<Genero> generos = new ArrayList<Genero>();
		for(GeneroEnum gen : GeneroEnum.values()) {
			generos.add(new Genero(gen.getCodigo(), gen.getGenero()));
		}
		
		return generos;
	}
	
	public void salvarLivro(Livro livro) {
		livro.setCdLivro(livros.size() + 1);
		livro.getGenero().setNmGenero(generos.get(livro.getGenero().getCdGenero() - 1).getNmGenero());
		this.livros.add(livro);
		
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	

}
