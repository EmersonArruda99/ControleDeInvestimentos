package com.meuprojeto.controledeinvestimentos.DTO;

import com.meuprojeto.controledeinvestimentos.model.enums.TipoProvento;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProventoResponseDTO(
        Long id,
        Long ativoId,
        String ticker,
        TipoProvento tipo,
        LocalDate dataPagamento,
        BigDecimal valorPorCota,
        Integer quantidade,
        BigDecimal valorRecebido
) {}