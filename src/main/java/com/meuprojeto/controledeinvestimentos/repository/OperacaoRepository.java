package com.meuprojeto.controledeinvestimentos.repository;

import com.meuprojeto.controledeinvestimentos.model.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
}
