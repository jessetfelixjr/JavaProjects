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

import classes.Genero;
import classes.Livro;
import rn.BibliotecaRN;

@Named
@ViewScoped
public class PrincipalMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Livro livro;
	private List<SelectItem> listaGeneros;
	
	private List<String> imagens;
	
	@Inject
	private BibliotecaRN rn;
	
	@PostConstruct
	public void init() {
		livro = new Livro();
		listaGeneros = new ArrayList<SelectItem>();
		
		for (Genero gen : rn.buscarGeneros()) {
			listaGeneros.add(new SelectItem(gen.getCdGenero(), gen.getNmGenero()));
		}
		
		imagens = new ArrayList<String>();
		for(int i = 1; i < 4; i++) {
			imagens.add("biblioteca" + i + ".jpg");
		}
		
		
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<SelectItem> getListaGeneros() {
		return listaGeneros;
	}
	
	public List<String> getImagens() {
		return imagens;
	}

	private FacesContext getCurrentInstance() {
		return FacesContext.getCurrentInstance();
	}

	public void salvar() {
		rn.salvarLivro(livro);
		livro = new Livro();
		getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Livro Salvo com sucesso"));
	}
	
	public void novo() {
		livro = new Livro();
	}

	
}
