package com.algaworks.cervejaria.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE}) //Para informar onde essa notação poderá ser utilizada
@Retention(RetentionPolicy.RUNTIME) //Para informar que essa notação vai ser avaliada em Tempo de Execução
@Constraint(validatedBy = {}) //Para informar que essa é uma notação que vai fazer uma validação
@Pattern(regexp = "([a-zA-Z]{2}\\d{4})?")
public @interface SKU {

	@OverridesAttribute(constraint = Pattern.class, name = "message")
	String message() default "SKU deve seguir o padrão XX9999";
	
	Class<?>[] groups() default {}; //Necessário inserir ou irá ocorrer erro, pois permite agrupar validações
	Class<? extends Payload>[] payload() default {}; //Necessário inserir ou irá ocorrer erro, pois permite carregar mais informações desse validador
}
