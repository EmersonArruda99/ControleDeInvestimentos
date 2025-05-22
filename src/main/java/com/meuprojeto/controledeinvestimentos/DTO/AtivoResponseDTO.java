package com.meuprojeto.controledeinvestimentos.DTO;

import lombok.Data;

@Data
public class AtivoResponseDTO {
    private Long id;
    private String ticker;
    private String nome;
    private String tipo;
    private String setor;
}
