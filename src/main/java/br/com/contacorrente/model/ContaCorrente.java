package br.com.contacorrente.model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="conta_corrente")
public class ContaCorrente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String codigo;
	
	@Column(nullable = false)
	private String agencia;
	
	@Column(nullable = false)
	private BigDecimal saldo;
	
	//VERIFICAR MAPEAMENTO PERFORMATICO
	private List<Transacao> transacoes = new LinkedList<>();

}
