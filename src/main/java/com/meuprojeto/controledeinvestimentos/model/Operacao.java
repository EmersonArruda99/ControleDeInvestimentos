package com.meuprojeto.controledeinvestimentos.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Operacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tipo; // Compra ou Venda

    private LocalDate data;

    private Integer quantidade;

    private BigDecimal precoUnitario;

    private BigDecimal corretagem;

    @ManyToOne
    @JoinColumn(name = "ativo_id")
    private Ativo ativo;

    public BigDecimal getTotal(){
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade)).add(corretagem);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public BigDecimal getCorretagem() {
        return corretagem;
    }

    public void setCorretagem(BigDecimal corretagem) {
        this.corretagem = corretagem;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }
}
