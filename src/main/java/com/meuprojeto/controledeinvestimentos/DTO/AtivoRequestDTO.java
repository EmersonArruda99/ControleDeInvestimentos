package com.meuprojeto.controledeinvestimentos.DTO;

import com.meuprojeto.controledeinvestimentos.model.enums.TipoAtivo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AtivoRequestDTO {

    @NotBlank
    private String ticker;

    @NotBlank
    private String nome;

    @NotNull
    private TipoAtivo tipo;

    @NotBlank
    private String setor;

}
