package com.algaworks.cervejaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CervejasController {

	@RequestMapping("/cervejas/novo")
	public String novo() {
		return "cerveja/CadastroCerveja";
	}
	
	//Parâmetro sku veio da propriedade name do input na página HTML, mapeamento feito pelo Spring Framework
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(String sku) {
		System.out.println("SKU: "+ sku);
		return "cerveja/CadastroCerveja";
	}
	
}
