package com.meuprojeto.controledeinvestimentos.DTO;

import com.meuprojeto.controledeinvestimentos.model.enums.TipoProvento;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProventoRequestDTO(
        @NotNull Long ativoId,
        @NotNull TipoProvento tipo,
        @NotNull LocalDate dataPagamento,
        @NotNull @DecimalMin(value = "0.0", inclusive = false) BigDecimal valorPorCota,
        @NotNull Integer quantidade,
        @NotNull @DecimalMin(value = "0.0", inclusive = false) BigDecimal valorRecebido
) {}