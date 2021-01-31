package br.com.contabancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contabancaria.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
