package classes;

import java.io.Serializable;

public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int cdCliente;
	
	private String nmCliente;
	
	private String nrTelefoneRes;
	
	public Cliente() {
		
	}
	
	public Cliente(int cdCliente, String nmCliente, String nrTelefoneRes) {
		super();
		this.cdCliente = cdCliente;
		this.nmCliente = nmCliente;
		this.nrTelefoneRes = nrTelefoneRes;
	}


	public int getCdCliente() {
		return cdCliente;
	}

	public void setCdCliente(int cdCliente) {
		this.cdCliente = cdCliente;
	}

	public String getNmCliente() {
		return nmCliente;
	}

	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}

	public String getNrTelefoneRes() {
		return nrTelefoneRes;
	}

	public void setNrTelefoneRes(String nrTelefoneRes) {
		this.nrTelefoneRes = nrTelefoneRes;
	}
	
	

}
