package br.com.contabancaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contabancaria.dto.ConsultaSaldoDTO;
import br.com.contabancaria.dto.ContaCorrenteDTO;
import br.com.contabancaria.model.ContaCorrente;
import br.com.contabancaria.service.ContaCorrenteService;
import br.com.contabancaria.service.TransacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/conta-corrente")
@Api(value = "Conta Corrente" )
public class ContaCorrenteController {
	
	@Autowired
	private ContaCorrenteService contaCorrenteService;
	
	@Autowired
	private TransacaoService transacaoService;
	
	@GetMapping
	@ApiOperation(value = "Consulta todas as contas correntes cadastradas.")
	public	ResponseEntity<List<ContaCorrenteDTO>> listar(){
		return new ResponseEntity<>(contaCorrenteService.listarContas(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ContaCorrenteDTO> criar(@RequestBody ContaCorrenteDTO contaCorrenteDTO){
		ContaCorrenteDTO novaContaCorrenteDTO = contaCorrenteService.salvar(contaCorrenteDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(novaContaCorrenteDTO);
	}
	
	@PutMapping
	public ResponseEntity<ContaCorrenteDTO> editar(@RequestBody ContaCorrenteDTO contaCorrenteDTO){
		ContaCorrenteDTO contaCorrenteAtualizadaDTO = contaCorrenteService.atualizar(contaCorrenteDTO);
		return ResponseEntity.ok(contaCorrenteAtualizadaDTO);
	}
	
	@DeleteMapping
	public ResponseEntity<ContaCorrenteDTO> deletar(@RequestBody ContaCorrenteDTO contaCorrenteDTO){
		contaCorrenteService.deletar(contaCorrenteDTO);
		return ResponseEntity.ok(contaCorrenteDTO);
	}
	
	@GetMapping("/saldo")
	public ResponseEntity<ConsultaSaldoDTO> editar(@RequestBody ConsultaSaldoDTO consultaSaldoDTO){
		ConsultaSaldoDTO consultaSaldo = transacaoService.consultarSaldo(consultaSaldoDTO);
		return ResponseEntity.ok(consultaSaldo);
	}

}
