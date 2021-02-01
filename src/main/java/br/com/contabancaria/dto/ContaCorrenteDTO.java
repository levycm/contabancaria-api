package br.com.contabancaria.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.contabancaria.model.ContaCorrente;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(description = "Informações de manipulação da conta corrente.")
public class ContaCorrenteDTO implements Serializable {
	
	private static final long serialVersionUID = 2335156818117410122L;
	
	@ApiModelProperty(hidden = true)
	private Long id;
	
	@ApiModelProperty(required = true, value = "Código da conta corrente.")
	private String codigo;
	
	@ApiModelProperty(required = true, value = "Agência que a conta corrente pertence.")
	private String agencia;
	
	@ApiModelProperty(value = "Saldo da conta corrente.")
	private BigDecimal saldo;
	
	public ContaCorrenteDTO() {}
	
	private ContaCorrenteDTO(Long id, String codigo, String agencia, BigDecimal saldo) {
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
