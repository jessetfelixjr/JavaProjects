package mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import classes.Livro;
import rn.BibliotecaRN;

@Named
@ViewScoped
public class LocacaoLivrosMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private BibliotecaRN rn;
	
	private DualListModel<Livro> listaLivros;
	
	
	@PostConstruct
	public void init() {
		iniciarListaLivros();
	}


	private void iniciarListaLivros() {
		List<Livro> listaLivrosDisp = rn.buscarLivrosDisponiveis();
		List<Livro> listaLivrosPedidos = new ArrayList<Livro>();
		
		listaLivros = new DualListModel<Livro>(listaLivrosDisp, listaLivrosPedidos);
	}


	public DualListModel<Livro> getListaLivros() {
		return listaLivros;
	}
	
	public void setListaLivros(DualListModel<Livro> listaLivros) {
		this.listaLivros = listaLivros;
	}


	public void confirmarLocacao() {
		rn.confirmarLocacao(listaLivros.getTarget());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Livro alugado com sucesso"));
		iniciarListaLivros();
	}
	
	

	
}
