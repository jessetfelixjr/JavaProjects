package br.com.projetos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@RequestMapping("/")
	public ModelAndView welcome() {
		ModelAndView model = new ModelAndView("welcome");
		
		
		
		return model;
	}
	
	


}
