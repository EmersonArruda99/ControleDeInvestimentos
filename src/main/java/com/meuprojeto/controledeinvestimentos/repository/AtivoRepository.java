package com.meuprojeto.controledeinvestimentos.repository;

import com.meuprojeto.controledeinvestimentos.model.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtivoRepository extends JpaRepository<Ativo, Long> {
}
