package classes;

import java.io.Serializable;


/**
 * The persistent class for the genero database table.
 * 
 */
public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;

	private int cdGenero;

	private String nmGenero;

	public Genero() {
	}

	public Genero(int cdGenero, String nmGenero) {
		super();
		this.cdGenero = cdGenero;
		this.nmGenero = nmGenero;
	}

	public int getCdGenero() {
		return this.cdGenero;
	}

	public void setCdGenero(int cdGenero) {
		this.cdGenero = cdGenero;
	}

	public String getNmGenero() {
		return this.nmGenero;
	}

	public void setNmGenero(String nmGenero) {
		this.nmGenero = nmGenero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cdGenero;
		result = prime * result + ((nmGenero == null) ? 0 : nmGenero.hashCode());
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
		Genero other = (Genero) obj;
		if (cdGenero != other.cdGenero)
			return false;
		if (nmGenero == null) {
			if (other.nmGenero != null)
				return false;
		} else if (!nmGenero.equals(other.nmGenero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Genero [cdGenero=" + cdGenero + ", nmGenero=" + nmGenero + "]";
	}
	
	
	

}