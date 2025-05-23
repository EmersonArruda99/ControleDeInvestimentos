package com.meuprojeto.controledeinvestimentos.model;

import com.meuprojeto.controledeinvestimentos.model.enums.TipoAtivo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Ativo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Ticker é obrigatorio")
    private String ticker;

    private String nome;

    @NotNull(message = "Tipo do ativo é obrigatório")
    @Enumerated(EnumType.STRING)
    private TipoAtivo tipo;

    private String setor;

}
