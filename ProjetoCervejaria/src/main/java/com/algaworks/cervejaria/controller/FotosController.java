package com.algaworks.cervejaria.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.cervejaria.dto.FotoDTO;
import com.algaworks.cervejaria.storage.FotoStorageRunnable;

@RestController //Foi utilizado RestController ao invés de só Controller porque a requisição está sendo feita via Ajax no action do Javascript do CadastroCerveja 
@RequestMapping("/fotos")
public class FotosController {

	@PostMapping
	public DeferredResult<FotoDTO> upload(@RequestParam("files[]") MultipartFile[] files) {
		DeferredResult<FotoDTO> resultado = new DeferredResult<>();
		
		Thread thread = new Thread(new FotoStorageRunnable(files, resultado));
		thread.start();
		
		return resultado;
	}
}
