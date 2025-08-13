package com.algaworks.cervejaria.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.algaworks.cervejaria.controller.CervejariaController;

@Configuration
//@ComponentScan("com.algaworks.cervejaria.controller") - Poderia ser feito setado o pacote do controller como uma string, mas fica sucetível a erros de digitação
@ComponentScan(basePackageClasses = { CervejariaController.class}) //basePackageClasses nós estamos pedindo para encontrar todas as classes com notação de @Controller no mesmo pacote da classe que colocamos o nome, dentro {} é um vetor podemos colocar outros nomes de classes
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter{

}
