package mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import classes.Livro;
import rn.BibliotecaRN;

@Named
@ViewScoped
public class ListagemLivrosMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Livro> listaLivros;
	
	@Inject
	private BibliotecaRN rn;
	
	@PostConstruct
	public void init(){
		listaLivros = rn.buscarLivros();
	}

	public List<Livro> getListaLivros() {
		return listaLivros;
	}
	
	
	
}
