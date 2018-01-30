package rn;

import java.util.List;

import javax.ejb.Stateless;

import classes.Genero;
import classes.Livro;
import dao.BibliotecaDAO;

@Stateless
public class BibliotecaRN {
	
	private BibliotecaDAO bibliotecaDAO;
	
	public BibliotecaRN() {
		bibliotecaDAO = new BibliotecaDAO();
	}
	
	public List<Genero> buscarGeneros(){
		return bibliotecaDAO.getGeneros();
	}

	public List<Livro> buscarLivros() {
		return bibliotecaDAO.getLivros();
	}
	
	public void salvarLivro(Livro livro) {
		bibliotecaDAO.salvarLivro(livro);
	}
}
