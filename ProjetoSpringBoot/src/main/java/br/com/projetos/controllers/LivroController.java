package br.com.projetos.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetos.classes.Genero;
import br.com.projetos.classes.Livro;
import br.com.projetos.repositories.GeneroRepository;
import br.com.projetos.repositories.LivroRepository;

@Controller
public class LivroController {

	@Autowired
	private GeneroRepository generoRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@RequestMapping("/livro")
	public ModelAndView welcome() {
		ModelAndView model = new ModelAndView("livro");
		inicializarModel(model);
		return model;
	}
	
	
	@PostMapping("/cadastrarLivro")
    public ModelAndView adicionarLivro(@ModelAttribute Livro livro) {
		ModelAndView model = new ModelAndView("livro");
		Optional<Genero> gen = generoRepository.findById(livro.getGenero().getCodigo());
		livro.setGenero(gen.get());
		livroRepository.save(livro);
		inicializarModel(model);
		return model;
		
		
    }
	
	@PostMapping("/excluirLivro")
    public ModelAndView excluirLivro(@ModelAttribute("livro") Livro livro, ModelMap modelMap) {
		ModelAndView model = new ModelAndView("livro");
		livroRepository.deleteById(livro.getCodigo());
		inicializarModel(model);
		return model;
		
		
    }
	
	@PostMapping("/adicionarGenero")
	 public ModelAndView adicionarGenero(@ModelAttribute Genero genero, ModelAndView modelMap, Model m) {
		ModelAndView model = new ModelAndView("livro");
		generoRepository.save(genero);
		inicializarModel(model);
		return model;
		
	}
	
	private void inicializarModel(ModelAndView model) {
		model.addObject("genero", new Genero());
		model.addObject("generos", generoRepository.findAll());
		model.addObject("livros", livroRepository.findAll());
		model.addObject("livro", new Livro());
	}

}
