package com.meuprojeto.controledeinvestimentos.repository;

import com.meuprojeto.controledeinvestimentos.model.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {

    List<Operacao> findByAtivoId(Long ativoId);
}
