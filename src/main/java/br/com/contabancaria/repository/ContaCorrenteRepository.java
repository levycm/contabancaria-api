package br.com.contabancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contabancaria.model.ContaCorrente;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {
	
	ContaCorrente findByCodigoAndAgencia(String codigo, String agencia);

}
