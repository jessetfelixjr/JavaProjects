package mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import classes.Cliente;
import rn.BibliotecaRN;

@Named
@ViewScoped

public class ClienteMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Cliente> listaClientes;
	private Cliente cliente;
	
	@Inject
	private BibliotecaRN rn;
	
	@PostConstruct
	public void init() {
		iniciarListaClientes();
	}
	
	@PreDestroy
	public void destroy() {
		listaClientes.remove(cliente);
		cliente = null;
	}

	private void iniciarListaClientes() {
		listaClientes = rn.buscarClientes();
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void adicionarCliente() {
		cliente = new Cliente();
		listaClientes.add(cliente);
	}
	
	public void salvarCliente() {
		listaClientes.remove(cliente);
		rn.salvarCliente(cliente);
		cliente = null;
		
		iniciarListaClientes();
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sucesso", "Cliente adicionado com sucesso"));
	}

}
