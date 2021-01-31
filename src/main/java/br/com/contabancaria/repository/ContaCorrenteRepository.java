package br.com.contabancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contabancaria.model.ContaCorrente;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

}
