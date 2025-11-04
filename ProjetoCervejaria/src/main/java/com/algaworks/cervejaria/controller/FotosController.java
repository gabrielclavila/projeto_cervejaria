package com.algaworks.cervejaria.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController //Foi utilizado RestController ao invés de só Controller porque a requisição está sendo feita via Ajax no action do Javascript do CadastroCerveja 
@RequestMapping("/fotos")
public class FotosController {

	@PostMapping
	public String upload(@RequestParam("files[]") MultipartFile[] files) {
		System.out.println(">>> files: " + files[0].getSize());
		return "Ok!";
	}
}
