package com.algaworks.cervejaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.algaworks.cervejaria.model.Cerveja;

@Controller
public class CervejasController {

	@RequestMapping("/cervejas/novo")
	public String novo() {
		return "cerveja/CadastroCerveja";
	}
	
	//Ao invés de passar uma lista de parâmetros caso o formulário de cadastro possua vários com o ideal é sempre passar o Objeto Cerveja para o método
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(Cerveja cerveja) {
		System.out.println("SKU: "+ cerveja.getSku());
		return "cerveja/CadastroCerveja";
	}
	
}
