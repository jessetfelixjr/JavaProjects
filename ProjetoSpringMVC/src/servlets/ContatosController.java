package servlets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import entidades.Contato;
import rn.ContatosRN;
import rn.ContatosRNImpl;

@Controller
public class ContatosController {
	
	private ContatosRN rn = new ContatosRNImpl();

	@RequestMapping("/")
	public ModelAndView run() {
		ModelAndView modelAndView = new ModelAndView("welcome");
		modelAndView.addObject("contato", new Contato());
		modelAndView.addObject("paramBusca", "");
		modelAndView.addObject("contatos", rn.buscarListaContatos());
		return modelAndView;
	}

	@RequestMapping(value = "/salvarContato", method = RequestMethod.POST)
	public ModelAndView adicionarContato(@ModelAttribute(value = "contato") Contato contato, BindingResult result,
			ModelMap model) {
		ModelAndView modelAndView = new ModelAndView("welcome");
		if (!result.hasErrors()) {
			System.out.println("Deu bom");
			rn.adicionarContato(contato);
			model.addAttribute("contato", new Contato());
			model.addAttribute("contatos", rn.buscarListaContatos());
		} else {
			System.out.println("Deu ruim");
		}

		return modelAndView;
	}

	@RequestMapping(value = "/editarContato/{contato.id}", params = "edit", method = RequestMethod.POST)
	public ModelAndView editarContato(@PathVariable("contato.id") long id) {
		ModelAndView modelAndView = new ModelAndView("welcome");
		modelAndView.addObject("contato", rn.buscarContatoPorId(id));
		modelAndView.addObject("contatos", rn.buscarListaContatos());
		return modelAndView;
	}

	@RequestMapping(value = "/editarContato/{contato.id}", params = "delete", method = RequestMethod.POST)
	public ModelAndView excluirContato(@PathVariable("contato.id") long id) {
		ModelAndView modelAndView = new ModelAndView("welcome");
		rn.removerContato(id);
		modelAndView.addObject("contato", new Contato());
		modelAndView.addObject("contatos", rn.buscarListaContatos());

		return modelAndView;
	}

	@RequestMapping(value = "/buscarContato/", method = RequestMethod.POST)
	public ModelAndView buscarContato(@RequestParam("paramBusca") String paramBusca) {
		ModelAndView modelAndView = new ModelAndView("welcome");
		modelAndView.addObject("contato", new Contato());
		modelAndView.addObject("contatos", rn.buscarContatoPorNome(paramBusca));
		return modelAndView;
	}

}
