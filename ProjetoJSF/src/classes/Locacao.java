package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Locacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int cdLocacao;
	
	private Cliente cliente;
	
	private List<Livro> livros;
	
	public Locacao() {
		cliente = new Cliente();
		livros = new ArrayList<Livro>();
		
	}
	
	public Locacao(int cdLocacao, Cliente cliente, List<Livro> livros) {
		super();
		this.cdLocacao = cdLocacao;
		this.cliente = cliente;
		this.livros = livros;
	}

	public int getCdLocacao() {
		return cdLocacao;
	}

	public void setCdLocacao(int cdLocacao) {
		this.cdLocacao = cdLocacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	

}
