package com.meuprojeto.controledeinvestimentos.repository;

import com.meuprojeto.controledeinvestimentos.model.Provento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProventoRepository extends JpaRepository<Provento, Long> {
}
