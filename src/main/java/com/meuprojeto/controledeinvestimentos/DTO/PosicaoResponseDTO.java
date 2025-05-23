package com.meuprojeto.controledeinvestimentos.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PosicaoResponseDTO {
    private Long ativoId;
    private String ticker;
    private int quantidade;
    private BigDecimal precoMedio;
    private BigDecimal valorInvestido;
    private BigDecimal totalCorretagem;
}