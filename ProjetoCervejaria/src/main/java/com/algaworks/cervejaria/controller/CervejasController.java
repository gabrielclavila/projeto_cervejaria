package com.algaworks.cervejaria.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.cervejaria.model.Cerveja;

@Controller
public class CervejasController {

	@RequestMapping("/cervejas/novo")
	public String novo() {
		return "cerveja/CadastroCerveja";
	}
	
	//Ao invés de passar uma lista de parâmetros caso o formulário de cadastro possua vários com o ideal é sempre passar o Objeto Cerveja para o método
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			model.addAttribute("mensagem", "Erro no Formulário");
			return "cerveja/CadastroCerveja"; //forward, redireciona para uma página
		}
		
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso"); //Cria uma sessão, para manter na mesma página mesmo com o redirect para poder exibir a mensagem na página
		System.out.println("SKU: "+ cerveja.getSku());
		return "redirect:/cervejas/novo"; //redirect, redireciona para uma URL
	}
	
}
