package com.alura.learning_spring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.learning_spring.interceptor.InterceptadorDeAcessos;
import com.alura.learning_spring.interceptor.InterceptadorDeAcessos.Acesso;

@RequestMapping("/api/acessos")
@RestController
public class AcessosController {

	@GetMapping
	public List<Acesso> getAcessos(){
		return InterceptadorDeAcessos.acessos;
	}
}
