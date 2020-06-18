package br.com.filipeapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilipeController {

	@GetMapping(value = "/")
	public String greeting() {
		
		return "Bem vindo ao servico";
	}
	
}
