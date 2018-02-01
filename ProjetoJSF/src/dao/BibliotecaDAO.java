package dao;

import java.util.ArrayList;
import java.util.List;

import classes.Cliente;
import classes.Genero;
import classes.Livro;
import classes.Locacao;
import enums.GeneroEnum;

public class BibliotecaDAO extends PadraoDAO {
	
	private List<Locacao> locacoes;
	private List<Cliente> clientes;
	private List<Livro> livros;
	private List<Genero> generos;
	
	public BibliotecaDAO() {
		
		locacoes = new ArrayList<Locacao>();
		clientes = new ArrayList<Cliente>();
		livros = new ArrayList<Livro>();
		generos = new ArrayList<Genero>();
		
		
		generos = buscarGeneros();
		
		livros.add(new Livro(1, "J.K. Rowling", "Harry Potter", generos.get(0)));
		livros.add(new Livro(2, "William P. Young", "A Cabana", generos.get(1)));
		livros.add(new Livro(3, "Markus Zusak", "A Menina que Roubava Livros", generos.get(0)));
		livros.add(new Livro(4, "C. S. Lewis", "As Crônicas de Narnia", generos.get(1)));
		
		clientes.add(new Cliente(1,"Jorge","(13) 3652-1475"));
		clientes.add(new Cliente(2,"Joana","(11) 3652-0012"));
		clientes.add(new Cliente(3,"Josefo","(13) 3320-1254"));
		clientes.add(new Cliente(4,"Joaquim","(13) 4563-2512"));
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
	
	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void confirmarLocacao(Integer cdCliente, List<Livro> livros) {
		
		int codigoLocacao = 0;
		
		if(locacoes.size() != 0) codigoLocacao = locacoes.size() - 1;
		
		
		locacoes.add(new Locacao(codigoLocacao, this.clientes.get(cdCliente - 1) ,livros));
		
		
		for(Livro l : livros) {
			l.setIcAlugado('s');
			this.livros.set(l.getCdLivro() - 1, l);			
		}
		
	}

	public List<Livro> getLivrosDisponiveis() {
		List<Livro> livrosDisponiveis = new ArrayList<Livro>();
		
		for(Livro l : this.livros) {
			if(l.getIcAlugado() == 'n') {
				livrosDisponiveis.add(l);
			}
		}
		
		return livrosDisponiveis;
	}

	public void salvarCliente(Cliente cliente) {
		cliente.setCdCliente(clientes.size() + 1);
		this.clientes.add(cliente);
	}

	

}
