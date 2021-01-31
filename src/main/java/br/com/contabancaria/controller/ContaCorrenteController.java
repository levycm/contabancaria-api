package br.com.contabancaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contabancaria.model.ContaCorrente;
import br.com.contabancaria.service.ContaCorrenteService;

@RestController
@RequestMapping("/conta-corrente")
public class ContaCorrenteController {
	
	@Autowired
	private ContaCorrenteService contaCorrenteService;
	
	@GetMapping
	public List<ContaCorrente> listar(){
		return contaCorrenteService.listarContas();
	}

}
