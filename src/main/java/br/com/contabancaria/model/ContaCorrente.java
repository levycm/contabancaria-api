package br.com.contabancaria.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.contabancaria.dto.ContaCorrenteDTO;
import lombok.Data;

@Data
@Entity
@Table(name="conta_corrente")
public class ContaCorrente implements Serializable {
	
	private static final long serialVersionUID = -9041541206855238962L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String codigo;
	
	@Column(nullable = false)
	private String agencia;
	
	@Column
	private BigDecimal saldo;
	
	public ContaCorrente() {}

	private ContaCorrente(Long id, String codigo, String agencia, BigDecimal saldo) {
		this.id = id;
		this.codigo = codigo;
		this.agencia = agencia;
		this.saldo = saldo;
	}
	
	public static ContaCorrente of(Long id, String codigo, String agencia, BigDecimal saldo) {
		return new ContaCorrente(id, codigo, agencia, saldo);
	}
	
	public ContaCorrenteDTO getContaCorrenteDTO() {
		return ContaCorrenteDTO.of(id, codigo, agencia, saldo);
	}

}
