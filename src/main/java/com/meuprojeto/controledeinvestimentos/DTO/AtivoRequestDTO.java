package com.meuprojeto.controledeinvestimentos.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AtivoRequestDTO {

    @NotBlank
    private String ticker;

    @NotBlank
    private String nome;

    @NotBlank
    private String tipo;

    @NotBlank
    private String setor;

}
