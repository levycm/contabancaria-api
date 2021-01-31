package br.com.contabancaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contabancaria.dto.ContaCorrenteDTO;
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
	
	@PostMapping
	public ResponseEntity<ContaCorrenteDTO> criar(@RequestBody ContaCorrenteDTO contaCorrenteDTO){
		ContaCorrenteDTO novaContaCorrenteDTO = contaCorrenteService.salvar(contaCorrenteDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(novaContaCorrenteDTO);
	}
	
//	@PutMapping
//	public ContaCorrente editar(@RequestBody ContaCorrenteDTO contaCorrenteDTO){
//		return contaCorrenteService.salvar(contaCorrenteDTO);
//	}
	
	@DeleteMapping
	public void deletar(@RequestBody ContaCorrente contaCorrente){
		contaCorrenteService.deletar(contaCorrente.getId());
	}

}
