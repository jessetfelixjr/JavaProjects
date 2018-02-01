package rn;

import java.util.List;

import javax.ejb.Stateless;

import classes.Cliente;
import classes.Genero;
import classes.Livro;
import classes.Locacao;
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

	public void confirmarLocacao(Integer cdCliente, List<Livro> livros) {
		bibliotecaDAO.confirmarLocacao(cdCliente, livros);
	}

	public List<Livro> buscarLivrosDisponiveis() {
		return bibliotecaDAO.getLivrosDisponiveis();
	}
	
	public List<Locacao> buscarLocacoes(){
		return bibliotecaDAO.getLocacoes();
	}
	
	public List<Cliente> buscarClientes(){
		return bibliotecaDAO.getClientes();
	}

	public void salvarCliente(Cliente cliente) {
		bibliotecaDAO.salvarCliente(cliente);
	}
}
