package br.com.contabancaria.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="transacao")
public class Transacao {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private int tipo;
	
	@Column(name = "data_hora", nullable= false)
	private LocalDateTime dataHora = LocalDateTime.now();
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
	private ContaCorrente contaCorrente;

}
