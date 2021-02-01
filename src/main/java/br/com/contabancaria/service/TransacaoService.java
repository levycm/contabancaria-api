package br.com.contabancaria.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contabancaria.dto.ConsultaSaldoDTO;
import br.com.contabancaria.model.ContaCorrente;
import br.com.contabancaria.repository.ContaCorrenteRepository;

@Service
public class TransacaoService {
	
	@Autowired
	ContaCorrenteRepository contaCorrenteRepository; 
	
	public ConsultaSaldoDTO consultarSaldo(ConsultaSaldoDTO consultaSaldoDTO) {
		ContaCorrente contaCorrenteDb = contaCorrenteRepository.findByCodigoAndAgencia(consultaSaldoDTO.getCodigo(), consultaSaldoDTO.getAgencia());
		consultaSaldoDTO.setSaldo(contaCorrenteDb.getSaldo());
		return consultaSaldoDTO;
	}
	

}
