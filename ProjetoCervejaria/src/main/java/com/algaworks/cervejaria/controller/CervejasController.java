package com.algaworks.cervejaria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.cervejaria.model.Cerveja;
import com.algaworks.cervejaria.model.Origem;
import com.algaworks.cervejaria.model.Sabor;
import com.algaworks.cervejaria.repository.Estilos;

@Controller
public class CervejasController {
	
	@Autowired
	private Estilos estilos; //Injeção de Depedência com o Padrão Repository
	
	@RequestMapping("/cervejas/novo")
	public ModelAndView novo(Cerveja cerveja) {
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		return mv;
	}
	
	//Ao invés de passar uma lista de parâmetros caso o formulário de cadastro possua vários com o ideal é sempre passar o Objeto Cerveja para o método
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cerveja); //forward, redireciona para uma página
		}
		
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso"); //Cria uma sessão, para manter na mesma página mesmo com o redirect para poder exibir a mensagem na página
		System.out.println("SKU: "+ cerveja.getSku());
		return new ModelAndView("redirect:/cervejas/novo"); //redirect, redireciona para uma URL
	}
	
}
