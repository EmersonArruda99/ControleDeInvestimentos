package com.meuprojeto.controledeinvestimentos.DTO;

import com.meuprojeto.controledeinvestimentos.model.enums.TipoOperacao;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OperacaoResponseDTO {
    private Long id;
    private TipoOperacao tipo;
    private LocalDate data;
    private Integer quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal corretagem;
    private BigDecimal total;

    // Dados do Ativo
    private Long ativoId;
    private String ticker;
    private String nome;
    private String tipoAtivo;
    private String setor;
}
