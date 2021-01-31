package br.com.contabancaria.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.contabancaria.model.ContaCorrente;
import lombok.Data;


@Data
public class ContaCorrenteDTO implements Serializable {
	
	private static final long serialVersionUID = 2335156818117410122L;
	
	private Long id;
	private String codigo;
	private String agencia;
	private BigDecimal saldo;
	
	public ContaCorrenteDTO() {}
	
	public ContaCorrenteDTO(Long id, String codigo, String agencia, BigDecimal saldo) {
		this.id = id;
		this.codigo = codigo;
		this.agencia = agencia;
		this.saldo = saldo;
	}	
	
	public ContaCorrente mapperToContaCorrente() {
		ContaCorrente contaCorrente = ContaCorrente.of(id, codigo, agencia, saldo);
		return contaCorrente;
	}
	
	public static ContaCorrenteDTO of(Long id, String codigo, String agencia, BigDecimal saldo) {
		return new ContaCorrenteDTO(id, codigo, agencia, saldo);
	}



	

}
