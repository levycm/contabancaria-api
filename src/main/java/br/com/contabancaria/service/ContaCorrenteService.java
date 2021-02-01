package br.com.contabancaria.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

import br.com.contabancaria.repository.ContaCorrenteRepository;
import br.com.contabancaria.dto.ContaCorrenteDTO;
import br.com.contabancaria.model.ContaCorrente;

@Service
public class ContaCorrenteService {
	
	@Autowired
	ContaCorrenteRepository contaCorrenteRepository;
	
	public List<ContaCorrenteDTO> listarContas() {
		Iterable<ContaCorrente> contaCorrentes = contaCorrenteRepository.findAll();
        return Lists.newArrayList(contaCorrentes).stream().map(conta -> conta.getContaCorrenteDTO())
                .collect(Collectors.toList());
	}
	
	public ContaCorrenteDTO salvar(ContaCorrenteDTO contaCorrenteDTO) {
		ContaCorrente contaCorrente = contaCorrenteDTO.mapperToContaCorrente();
		contaCorrenteRepository.save(contaCorrente);
		return contaCorrente.getContaCorrenteDTO();
	}
	
	public ContaCorrenteDTO atualizar(ContaCorrenteDTO contaCorrenteDTO) {
		ContaCorrente contaCorrenteDb = contaCorrenteRepository.getOne(contaCorrenteDTO.getId());
		ContaCorrente contaCorrente = contaCorrenteDTO.mapperToContaCorrente();
		BeanUtils.copyProperties(contaCorrente, contaCorrenteDb, "id");
		contaCorrenteRepository.save(contaCorrente);
		return contaCorrente.getContaCorrenteDTO();
	}
	
	public void deletar(ContaCorrenteDTO contaCorrenteDTO) {
		ContaCorrente contaCorrente = contaCorrenteRepository.getOne(contaCorrenteDTO.getId());
		contaCorrenteRepository.delete(contaCorrente);
	}
	
}
