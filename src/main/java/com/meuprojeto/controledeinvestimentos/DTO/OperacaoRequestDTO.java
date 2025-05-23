package com.meuprojeto.controledeinvestimentos.DTO;

import com.meuprojeto.controledeinvestimentos.model.enums.TipoOperacao;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OperacaoRequestDTO {
    @NotNull
    private TipoOperacao tipo;

    @NotNull
    private LocalDate data;

    @NotNull
    @Positive
    private Integer quantidade;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal precoUnitario;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal corretagem;

    @NotNull
    private Long ativoId;

}
