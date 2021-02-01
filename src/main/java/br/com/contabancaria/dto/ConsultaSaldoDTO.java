package br.com.contabancaria.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Informações referente a consulta de saldo da conta corrente.")
public class ConsultaSaldoDTO implements Serializable { 
	
	private static final long serialVersionUID = 5535456982652117209L;

	@ApiModelProperty(required = true, value = "Código da conta corrente.")
	private String codigo;
	
	@ApiModelProperty(required = true, value = "Agência que a conta corrente pertence.")
	private String agencia;
	
	@ApiModelProperty(value = "Saldo da conta corrente.")
	private BigDecimal saldo;

}
