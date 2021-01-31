package br.com.contabancaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import br.com.contabancaria.repository.ContaCorrenteRepository;
import br.com.contabancaria.model.ContaCorrente;

@Service
public class ContaCorrenteService {
	
	@Autowired
	ContaCorrenteRepository contaCorrenteRepository;
	
	public List<ContaCorrente> listarContas() {
		return contaCorrenteRepository.findAll();
	}
	
	public ContaCorrente salvar(ContaCorrente contaCorrente) {
		return contaCorrenteRepository.save(contaCorrente);
	}
	
	public void deletar(Long id) {
		ContaCorrente contaCorrente = contaCorrenteRepository.findById(id).get();
		contaCorrenteRepository.delete(contaCorrente);
	}

}
