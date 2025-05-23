package com.meuprojeto.controledeinvestimentos.DTO;

import com.meuprojeto.controledeinvestimentos.model.enums.TipoAtivo;
import lombok.Data;

@Data
public class AtivoResponseDTO {
    private Long id;
    private String ticker;
    private String nome;
    private TipoAtivo tipo;
    private String setor;
}
