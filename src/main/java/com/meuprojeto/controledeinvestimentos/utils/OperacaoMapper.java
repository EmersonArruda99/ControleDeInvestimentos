package com.meuprojeto.controledeinvestimentos.utils;

import com.meuprojeto.controledeinvestimentos.DTO.OperacaoResponseDTO;
import com.meuprojeto.controledeinvestimentos.model.Ativo;
import com.meuprojeto.controledeinvestimentos.model.Operacao;

public class OperacaoMapper {

    public static OperacaoResponseDTO toDTO(Operacao operacao) {
        Ativo ativo = operacao.getAtivo();

        OperacaoResponseDTO dto = new OperacaoResponseDTO();
        dto.setId(operacao.getId());
        dto.setTipo(operacao.getTipo());
        dto.setData(operacao.getData());
        dto.setQuantidade(operacao.getQuantidade());
        dto.setPrecoUnitario(operacao.getPrecoUnitario());
        dto.setCorretagem(operacao.getCorretagem());
        dto.setTotal(operacao.getTotal());

        if (ativo != null) {
            dto.setAtivoId(ativo.getId());
            dto.setTicker(ativo.getTicker());
            dto.setNome(ativo.getNome());
            dto.setTipoAtivo(ativo.getTipo().name());
            dto.setSetor(ativo.getSetor());
        }

        return dto;
    }
}
