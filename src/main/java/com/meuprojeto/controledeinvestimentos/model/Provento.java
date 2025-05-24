package com.meuprojeto.controledeinvestimentos.model;

import com.meuprojeto.controledeinvestimentos.model.enums.TipoProvento;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Provento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Ativo é obrigatório")
    @ManyToOne
    @JoinColumn(name = "ativo_id")
    private Ativo ativo;

    @NotNull(message = "Tipo do provento é obrigatório")
    @Enumerated(EnumType.STRING)
    private TipoProvento tipo;

    @NotNull(message = "Data de pagamento é obrigatória")
    private LocalDate dataPagamento;

    @NotNull(message = "Valor por cota é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "Valor por cota deve ser maior que zero")
    private BigDecimal valorPorCota;

    @NotNull(message = "Quantidade é obrigatória")
    private Integer quantidade;

    @NotNull(message = "Valor recebido é obrigatório")
    private BigDecimal valorRecebido;
}