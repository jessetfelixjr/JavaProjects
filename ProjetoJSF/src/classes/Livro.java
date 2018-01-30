package classes;

import java.io.Serializable;


/**
 * The persistent class for the livro database table.
 * 
 */
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;

	private int cdLivro;

	private String nmAutor;

	private String nmLivro;

	private Genero genero;

	public Livro() {
		genero = new Genero();
	}
	
	public Livro(int cdLivro, String nmAutor, String nmLivro, Genero genero) {
		super();
		this.cdLivro = cdLivro;
		this.nmAutor = nmAutor;
		this.nmLivro = nmLivro;
		this.genero = genero;
	}



	public int getCdLivro() {
		return this.cdLivro;
	}

	public void setCdLivro(int cdLivro) {
		this.cdLivro = cdLivro;
	}

	public String getNmAutor() {
		return this.nmAutor;
	}

	public void setNmAutor(String nmAutor) {
		this.nmAutor = nmAutor;
	}

	public String getNmLivro() {
		return this.nmLivro;
	}

	public void setNmLivro(String nmLivro) {
		this.nmLivro = nmLivro;
	}

	public Genero getGenero() {
		return this.genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}