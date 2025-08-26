package com.algaworks.cervejaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.algaworks.cervejaria.model.Cerveja;

@Controller
public class EstilosController {

	@RequestMapping("estilos/novo")
	public String novo(Model model) {
		model.addAttribute(new Cerveja());
		return "estilo/CadastroEstilo";
	}
	
}
