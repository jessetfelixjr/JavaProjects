package mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import classes.Cliente;
import classes.Livro;
import classes.Locacao;
import rn.BibliotecaRN;

@Named
@ViewScoped
public class LocacaoLivrosMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private BibliotecaRN rn;

	private DualListModel<Livro> listaLivros;

	private List<SelectItem> listaClientes;
	
	private List<Locacao> listaLocacoes;

	private Integer cdCliente;

	@PostConstruct
	public void init() {
		iniciarListaLivros();
	}

	private void iniciarListaLivros() {
		List<Livro> listaLivrosDisp = rn.buscarLivrosDisponiveis();
		List<Livro> listaLivrosPedidos = new ArrayList<Livro>();

		listaLivros = new DualListModel<Livro>(listaLivrosDisp, listaLivrosPedidos);

		List<Cliente> clientes = rn.buscarClientes();
		listaClientes = new ArrayList<SelectItem>();

		for (Cliente c : clientes) {
			listaClientes.add(new SelectItem(c.getCdCliente(), c.getNmCliente()));
		}
		
		listaLocacoes = rn.buscarLocacoes();

	}

	public DualListModel<Livro> getListaLivros() {
		return listaLivros;
	}

	public void setListaLivros(DualListModel<Livro> listaLivros) {
		this.listaLivros = listaLivros;
	}

	public List<SelectItem> getListaClientes() {
		return listaClientes;
	}

	public Integer getCdCliente() {
		return cdCliente;
	}

	public void setCdCliente(Integer cdCliente) {
		this.cdCliente = cdCliente;
	}

	
	public List<Locacao> getListaLocacoes() {
		return listaLocacoes;
	}
	
	public Integer getTamanhoLista() {
		return listaLocacoes.size();
	}

	public void confirmarLocacao() {

		if (listaLivros.getTarget().size() == 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Selecione, no mínimo, um livro"));
		} else {
			rn.confirmarLocacao(cdCliente, listaLivros.getTarget());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Livro alugado com sucesso"));
			iniciarListaLivros();
		}
	}

}
