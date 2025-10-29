package com.algaworks.cervejaria.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import com.algaworks.cervejaria.thymeleaf.processor.ClassforErrorAttributeTagProcessor;
import com.algaworks.cervejaria.thymeleaf.processor.MessageElementTagProcessor;

public class CervejariaDialect extends AbstractProcessorDialect {

	public CervejariaDialect() {
		super("AlgaWorks Cervejaria", "cervejaria", StandardDialect.PROCESSOR_PRECEDENCE); //Registro do Dialeto que vai ser referenciado no cabeçalho da página html "xmlns:cervejaria"
	}
	
	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassforErrorAttributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		return processadores;
	}

	
}
