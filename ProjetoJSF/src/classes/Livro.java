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
	
	private char icAlugado;

	public Livro() {
		genero = new Genero();
		icAlugado = 'n';
	}
	
	public Livro(int cdLivro, String nmAutor, String nmLivro, Genero genero) {
		super();
		this.cdLivro = cdLivro;
		this.nmAutor = nmAutor;
		this.nmLivro = nmLivro;
		this.genero = genero;
		this.icAlugado = 'n';
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

	public char getIcAlugado() {
		return icAlugado;
	}

	public void setIcAlugado(char icAlugado) {
		this.icAlugado = icAlugado;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cdLivro;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + icAlugado;
		result = prime * result + ((nmAutor == null) ? 0 : nmAutor.hashCode());
		result = prime * result + ((nmLivro == null) ? 0 : nmLivro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (cdLivro != other.cdLivro)
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (icAlugado != other.icAlugado)
			return false;
		if (nmAutor == null) {
			if (other.nmAutor != null)
				return false;
		} else if (!nmAutor.equals(other.nmAutor))
			return false;
		if (nmLivro == null) {
			if (other.nmLivro != null)
				return false;
		} else if (!nmLivro.equals(other.nmLivro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Livro [cdLivro=" + cdLivro + ", nmAutor=" + nmAutor + ", nmLivro=" + nmLivro + ", genero=" + genero
				+ ", icAlugado=" + icAlugado + "]";
	}
	
	
	
	

}