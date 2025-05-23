package com.meuprojeto.controledeinvestimentos.model;

import com.meuprojeto.controledeinvestimentos.model.enums.TipoOperacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Operacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Tipo é obrigatório")
    @Enumerated(EnumType.STRING)
    private TipoOperacao tipo; // Compra ou Venda

    @NotNull(message = "Data é obrigatória")
    private LocalDate data;

    @NotNull(message = "Quantidade é obrigatória")
    @Positive(message = "Quantidade deve ser maior que zero")
    private Integer quantidade;

    @NotNull(message = "Preço unitário é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "Preço deve ser maior que zero")
    private BigDecimal precoUnitario;

    @NotNull(message = "Corretagem é obrigatória")
    @DecimalMin(value = "0.0", inclusive = true, message = "Corretagem não pode ser negativa")
    private BigDecimal corretagem;

    @ManyToOne
    @JoinColumn(name = "ativo_id")
    private Ativo ativo;

    public BigDecimal getTotal(){
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade)).add(corretagem);
    }

}
