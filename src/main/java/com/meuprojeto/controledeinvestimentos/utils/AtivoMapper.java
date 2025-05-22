package com.meuprojeto.controledeinvestimentos.utils;

import com.meuprojeto.controledeinvestimentos.DTO.AtivoRequestDTO;
import com.meuprojeto.controledeinvestimentos.DTO.AtivoResponseDTO;
import com.meuprojeto.controledeinvestimentos.model.Ativo;

public class AtivoMapper {
    public static AtivoResponseDTO toDTO(Ativo ativo) {
        AtivoResponseDTO dto = new AtivoResponseDTO();
        dto.setId(ativo.getId());
        dto.setTicker(ativo.getTicker());
        dto.setNome(ativo.getNome());
        dto.setTipo(ativo.getTipo());
        dto.setSetor(ativo.getSetor());
        return dto;
    }

    public static Ativo toEntity(AtivoRequestDTO dto) {
        Ativo ativo = new Ativo();
        ativo.setTicker(dto.getTicker());
        ativo.setNome(dto.getNome());
        ativo.setTipo(dto.getTipo());
        ativo.setSetor(dto.getSetor());
        return ativo;
    }

    public static void updateEntity(Ativo ativo, AtivoRequestDTO dto) {
        ativo.setTicker(dto.getTicker());
        ativo.setNome(dto.getNome());
        ativo.setTipo(dto.getTipo());
        ativo.setSetor(dto.getSetor());
    }
}
